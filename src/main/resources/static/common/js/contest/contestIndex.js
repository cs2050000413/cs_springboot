
var pageCurr=1;
var tableIns;
var pageSize;
var form;
var table;

function getContestByName() {
    var name = $("#search").val();
    AsyncPost("/tbContest/getContestByName/",{"name":name},function (data) {
        initTableByData(data.data);

    })
}
function changeImg() {
    $("#img1").attr("src","common/images/me.jpg");
}

function initTableByData(obj){
    tableIns=table.render({
        elem:"#contestTable"
        ,data:obj
        //设置不分页
        ,limit: Number.MAX_VALUE
        ,cols: [[ //表头
            {field: 'id', title: 'ID',sort: true}
            ,{field: 'contestName', title: '竞赛名称', }
            ,{field: 'type', title: '类别', sort: true}
            ,{field: 'contestTime', title: '竞赛时间', sort: true}
            ,{field: 'remark', title: '备注'}
            ,{fixed:'right',title:'操作',align:'center', width:200, toolbar:'#barDemo'}
        ]],
    });
}

layui.use(["table"],function(){
    table = layui.table;
    form = layui.form;
    form.render();
    AsyncPost("/tbContest/getContest/",{"pageNum":pageCurr,"pageSize":10},function (data) {
        initTableByData(data.data);
    })


    //监听工具条
    table.on('tool(contestTable)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            //删除
            delContest(data,data.id);
        } else  if(obj.event === 'edit'){
            //编辑
            edit(data);
        }
    });

    //监听提交
    form.on('submit(contestSubmit)', function(data){
        formSubmit(data);
        return false;
    });

});


//提交表单
function formSubmit(obj){
    var url;
    if($("#id").val()=="自动生成") url = "/tbContest/setContest";else url = "/tbContest/updateContest";
    AsyncAjax("post",url,$("#contestForm").serialize(),function (data) {
        if (data.code == 0) {
            layer.alert(data.message,function(){
                layer.closeAll();
                load(obj);
            });
        } else {
            layer.alert(data.message);
        }
    });
}

//新增
function add() {
    edit(null,"新增");
}

//打开编辑框
function edit(data,title){
    if(data == null){
        $("#id").val("自动生成");
    }else{
        //回显数据
        $("#id").val(data.id);
        $("#contestName").val(data.contestName);
        $("#contestTime").val(data.contestTime);
        $("#type").val(data.type);
        $("#remark").val(data.remark);
        form.render();
    }
    var obj = $('#setContest');
    openForm(title,true,false,true,['400px','600px'],obj);
}

//删除
function delContest(obj,id) {
    if(null!=id){
        layer.confirm('您确定要删除吗？', {
            btn: ['确认','返回'] //按钮
        }, function(){
            AsyncDelete("/tbContest/delete",{"id":id},function(req){
                layer.alert(req.message,function(){
                    layer.closeAll();
                    load(obj);
                });
            });

        }, function(){
            layer.closeAll();
        });
    }
}

//重新加载table
function load(obj){
    AsyncPost("/tbContest/getContest/",{"pageNum":pageCurr,"pageSize":10},function (data) {
        initTableByData(data.data);
    })
}


