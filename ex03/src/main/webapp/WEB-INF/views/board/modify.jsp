<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--헤더 파일 넣기 --%>    
<%@ include file="../includes/header.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시판</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            게시글 수정하기
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="modify" method="post">
                                        <input type="hidden" name="bno" value="${board.bno}">
                                        
                                        <div class="form-group">
                                            <label>제목</label>
                                            <input class="form-control" placeholder="제목 입력" name="title" value="${board.title}">
                                        </div>
                                        <div class="form-group">
                                            <label>작성자</label>
                                            <input class="form-control" placeholder="작성자 입력" name="writer" value="${board.writer}" readonly>
                                        </div>                                        
                                        <div class="form-group">
                                            <label>Text area</label>
                                            <textarea class="form-control" rows="5" placeholder="내용 입력" name="content">${board.content}</textarea>
                                        </div>
                                        <button type="button" class="btn btn-default" data-oper="modify">수정하기</button>
                                        <button type="button" class="btn btn-default" data-oper="remove">삭제하기</button>
                                        <button type="button" class="btn btn-default" data-opoer="list">목록보기</button>>
                                     </form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>

	<script> //p262
	$(function(){  
		var formObj=$("form");
		
		$("button").on("click",function(e){
			e.preventDefault(); //버튼에 걸린 이벤트 없애고
			var operation = $(this).data("oper") // data-oper속성의 값읽기 즉,어떤 버튼인지 확인
			//if(operation==="modify") //수정 버튼이 눌리면
				
			if(operation==="remove") //삭제 버튼이 눌리면
				formObj.attr("action","/board/remove");
			else if(operation==="list"){ //리스트 버튼이 눌리면
				self.location="/board/list";  //board/list 요청
				return; //리턴없으면 아래문장이 실행됨으로
			}
			console.log("submit 동작합니다.");
			formObj.submit(); //submit 전송
		}); //e는 버튼 이벤트
		
		
		
	});
	
	
	</script>


</body>

</html>
