$(function () {
    var slider = new SliderUnlock("#slider",{
			successLabelTip : "验证成功"	
		},function(){
			alert("验证成功,即将跳转至#");
        	window.location.href="#";
			//以下四行设置恢复初始，不需要可以删除
			setTimeout(function(){
		        $("#labelTip").html("拖动滑块验证");
				$("#labelTip").css("color","#787878");
				},2000);
			slider.init();
		});
    slider.init();
})