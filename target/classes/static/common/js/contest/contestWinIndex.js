
var pageCurr=1;
var tableIns;
var pageSize;
var form;
var table;

function getContestWinByName() {
    var name = $("#search").val();
    AsyncPost("/tbContestWin/getContestWinByName/",{"name":name},function (data) {
        initTableByData(data.data);

    })
}
function changeImg() {
    $("#img1").attr("src","common/images/me.jpg");
}

function initTableByData(obj){
    tableIns=table.render({
        elem:"#contestWinTable"
        ,data:obj
        //设置不分页
        ,limit: Number.MAX_VALUE
        ,cols: [[ //表头
            {field: 'id', title: 'ID',sort: true}
            ,{field: 'contestId', title: '竞赛ID', sort: true}
            ,{field: 'contestName', title: '竞赛名称', sort: true}
            ,{field: 'contestType', title: '竞赛类别', sort: true}
            ,{field: 'contestTime', title: '竞赛时间', sort: true}
            ,{field: 'winType', title: '获奖类别', sort: true}
            ,{field: 'winTime', title: '获奖时间', sort: true}
            ,{field: 'remark', title: '备注'}
            ,{fixed:'right',title:'操作',align:'center', width:200, toolbar:'#barDemo'}
        ]],
    });
}

layui.use(["table"],function(){
    table = layui.table;
    form = layui.form;
    form.render();
    AsyncPost("/tbContestWin/getContestWin/",{"pageNum":pageCurr,"pageSize":10},function (data) {
        initTableByData(data.data);
    })


    //监听工具条
    table.on('tool(contestWinTable)', function(obj){
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
    form.on('submit(contestWinSubmit)', function(data){
        formSubmit(data);
        return false;
    });

});


//提交表单
function formSubmit(obj){
    var url;
    if($("#id").val()=="自动生成") url = "/tbContestWin/setContestWin";else url = "/tbContestWin/updateContestWin";
    AsyncAjax("post",url,$("#contestWinForm").serialize(),function (data) {
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
        $("#contestId").val(data.contestId);
        $("#winTime").val(data.winTime);
        $("#winType").val(data.winType);
        $("#remark").val(data.remark);
        form.render();
    }
    var obj = $('#setContestWin');
    openForm(title,true,false,true,['400px','600px'],obj);
}

//删除
function delContest(obj,id) {
    if(null!=id){
        layer.confirm('您确定要删除吗？', {
            btn: ['确认','返回'] //按钮
        }, function(){
            AsyncDelete("/tbContestWin/delete",{"id":id},function(req){
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
    AsyncPost("/tbContestWin/getContestWin/",{"pageNum":pageCurr,"pageSize":10},function (data) {
        initTableByData(data.data);
    })
}


