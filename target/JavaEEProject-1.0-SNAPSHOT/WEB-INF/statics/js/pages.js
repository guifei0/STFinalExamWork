
	
					$(function(){
						var curPage = 1; //当前页码
						var total,pageSize,totalPage; //总记录数，每页显示数，总页数
						getData(1);
						$("#pagecount").on('click','span a',function(){
							var rel = $(this).attr("rel");
							if(rel){
								getData(rel);
							}
						});
						function getData(page){
							$.ajax({
								url:"/User/showAllUsers",
								type:'POST',
								data: {'pageNum':page},
								beforeSend:function(){
										
								},
								success:function(data){
									// var one = eval('('+ data +')');/
									console.log(data);
									$('#tabBody').find('*').remove();
									for(var j=0;j<data['list'].length;j++){
										var item="<tr><td>"+data['list'][j].userName+"</td><td>"+"******"+"</td><td>"+data['list'][j].userPostbox+"</td><td>"+data['list'][j].userPhone+"</td><td>"+data['list'][j].userWish+"</td><td><button class='delete'>删除</button></td></tr>";
										$("#tabBody").append(item);
										$(".delete").eq(j).attr("id",data['list'][j].userId);
									}
									$(".delete").click(function(){
										var idH = $(this).attr("id");
										console.log(idH);
										$.ajax({
											url:"/User/deleteUser",
											type:'POST',
												data:{'userid':idH},
											dataType:"json",
											success:function(data){
												if(data['isSucceed']==1){
													alert("成功！");
													location.reload();
												}else{
													alert("失败");
												}
											},
											error:function(){
												alert("异常");
											}
	
										})
									})

									total = data['total']; //总记录数
									pageSize = 5; //每页显示条数
									curPage = page; //当前页
									totalPage = data['pages']; //总页数
									// console.log(one.yeshu);

									string='';
									// console.log(page);
									for(var i=0;i<data['list'].length;i++){
											string+='';
									}
									// $('.theme_body').append(string);
										
								},
								complete:function(){ //生成分页条
									getPageBar();
									// console.log(2);
									
								},
								error:function(){
									alert("数据加载失败");
								}
							});
						}
						//获取分页条
						function getPageBar(){
							console.log(totalPage);
						$("#pagecount").find('*').remove();
						//页码大于最大页数
						if(curPage>totalPage) {
							curPage=totalPage;
						}
						//页码小于1
						if(curPage<1) {
							curPage=1;
						}
						pageStr = "<span>共"+total+"条</span><span>"+curPage+"/"+totalPage+"</span>";
							
						//如果是第一页
						if(curPage==1){
							pageStr += "<span>首页</span><span>上一页</span>";
						}else{
							pageStr += "<span><a rel='1'>首页</a></span><span><a  rel='"+(curPage-1)+"'>上一页</a></span>";
						}
							
						//如果是最后页
						if(curPage>=totalPage){
							pageStr += "<span>下一页</span><span>尾页</span>";
						}else{
							pageStr += "<span><a rel='"+(parseInt(curPage)+1)+"'>下一页</a></span><span><a rel='"+totalPage+"'>尾页</a></span>";
						}  
						$("#pagecount").append(pageStr);
					}
					})
						
					