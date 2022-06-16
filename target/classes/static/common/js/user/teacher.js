
var pageCurr=1;
var tableIns;
var pageSize;
var form;
var table;

function getUserByName() {
    var name = $("#search").val();
    AsyncPost("/tbUser/getUserByName/",{"name":name},function (data) {
        initTableByData(data.data);

    })
}
function changeImg() {
    $("#img1").attr("src","common/images/me.jpg");
}

function initTableByData(obj){
    tableIns=table.render({
        elem:"#teacherTable"
        ,data:obj
        //设置不分页
        ,limit: Number.MAX_VALUE
        ,cols: [[ //表头
            {field: 'id', title: 'ID',sort: true}
            ,{field: 'userName', title: '教师姓名', }
            ,{field: 'phone', title: '手机号', }
            ,{field: 'sex', title: '性别', sort: true,templet:"#handleSex"}
            ,{field: 'age', title: '年龄', sort: true}
        ]],
    });
}

layui.use(["table"],function(){
    table = layui.table;
    form = layui.form;
    form.render();
    AsyncPost("/tbUser/getTeacher/",{"pageNum":pageCurr,"pageSize":10},function (data) {
        initTableByData(data.data);
    })
});

//重新加载table
function load(obj){
    AsyncPost("/tbUser/getTeacher/",{"pageNum":pageCurr,"pageSize":10},function (data) {
        initTableByData(data.data);
    })
}


