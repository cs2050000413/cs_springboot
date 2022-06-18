
var pageCurr=1;
var tableIns;
var pageSize;
var form;
var table;

function changeImg() {
    $("#img1").attr("src","common/images/me.jpg");
}


function initTableByData1(obj){
    tableIns=table.render({
        elem:"#contestTable"
        ,data:obj
        //设置不分页
        ,limit: Number.MAX_VALUE
        ,cols: [[ //表头
            {field: 'id', title: 'ID'}
            ,{field: 'contestName', title: '竞赛名称', }
            ,{field: 'type', title: '类别'}
            ,{field: 'contestTime', title: '竞赛时间'}
            ,{field: 'remark', title: '备注'}
        ]],
    });
}

function initTableByData(obj){
    tableIns=table.render({
        elem:"#userTable"
        ,data:obj
        //设置不分页
        ,limit: Number.MAX_VALUE
        ,cols: [[ //表头
            {field: 'id', title: 'ID',sort: true}
            ,{field: 'userName', title: '用户名', }
            ,{field: 'pname', title: '姓名', }
            ,{field: 'phone', title: '手机号', }
            ,{field: 'sex', title: '性别', sort: true,templet:"#handleSex"}
            ,{field: 'age', title: '年龄', sort: true}
            ,{field: 'role', title: '角色', sort: true}
            ,{fixed:'right',title:'操作',align:'center', width:200, toolbar:'#barDemo'}
        ]],
    });
}


layui.use(["table"],function(){
    table = layui.table;
    form = layui.form;
    form.render();
    var id = parent.contestId;
    AsyncPost("/tbUser/getPerson/?contestId="+id,{"pageNum":pageCurr,"pageSize":10},function (data) {
        initTableByData(data.data);
    })
    AsyncPost("/tbContest/getContestById/?contestId="+id,{"pageNum":pageCurr,"pageSize":10},function (data) {
        initTableByData1(data.data);
    })


    //监听工具条
    table.on('tool(userTable)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            //删除
            delUser(data,data.id);
        }
    });
    //监听提交
    form.on('submit(userSubmit)', function(data){
        formSubmit(data);
        return false;
    });
});


//提交表单
function formSubmit(obj){
    var url;
    var cid = parent.contestId;
        url = "/tbUser/addContestUser";
        AsyncAjax("post",url, {"cid":cid,"id":document.getElementById("userId").value},function (data) {
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
//
// //新增
// function add() {
//     alert("!");
//     $("#cid").val(data.cid);
//     form.render();
//     var obj = $('#setContestUser');
//     parent.openForm("新增",true,false,true,['400px','280px'],obj);
// }

//删除
function delUser(obj,id) {
    if(null!=id){
        layer.confirm('您确定要退选竞赛吗？', {
            btn: ['确认','返回'] //按钮
        }, function(){
            AsyncDelete("/tbUser/deleteContestUser",{"id":id},function(req){
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
    var id = parent.contestId;
    AsyncPost("/tbUser/getPerson/?contestId="+id,{"pageNum":pageCurr,"pageSize":10},function (data) {
        initTableByData(data.data);
    })
    AsyncPost("/tbContest/getContestById/?contestId="+id,{"pageNum":pageCurr,"pageSize":10},function (data) {
        initTableByData1(data.data);
    })
}


