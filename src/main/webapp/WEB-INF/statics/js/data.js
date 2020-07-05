var data = [{
    userWish: "大声说出你的新年愿望!"
},
{
    userWish: "大声说出你的新年愿望!"
},
{
    userWish: "大声说出你的新年愿望!"
},
{
    userWish: "大声说出你的新年愿望!"
},{
    userWish: "大声说出你的新年愿望!"
},{
    userWish: "大声说出你的新年愿望!"
},{
    userWish: "大声说出你的新年愿望!"
}];
//从后台取数据
$.ajax({
    type:"POST",
    dataType:"json",
    url:"/User/showAllWishes",
    async: false,
    success: function(st) {
        // var arr=data.list;
        // var idStr="";
        // for(var i=0;i<data.list.length;i++){
        //     var name=arr[i].userName;
        //     var id=arr[i].userId+" "+name+" ";
        //     idStr=idStr.concat(id);
        console.log(1);
       console.log(st.list);
        $.extend(true, data, st.list); //st覆盖data
       console.log(data);
    }
});
var num = data.length;
for (var i = 0; i < num; i++) {
    $("ul").append("<li ><div class='barYe'>" + data[i].userWish + "</div></li>");
    // $("li").addClass("journal-reward");
    if(i==3){
    	$("ul li:eq(5)").slideDown(10);
    }
    
}

function add() {
  $.ajax({
        url: "/User/showAllWishes",
        type: "post",
        dataType:"json",
        async: false,
        success: function(st) {
            //console.log(st);
            $.extend(true, data, st.list);
            //console.log(data);
        }
    });
    var num = data.length;
    for (var i = 0; i < num; i++) {
        $("ul").append("<li ><div class='barYe'>" + data[i].userWish + "</div></li>");
        //console.log(data[i].text);
    }

}