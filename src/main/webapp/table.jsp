<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- Test URL
http://localhost:8080/elJstl-live/table.jsp?r=5&c=3
 --%>
<%
	String row = request.getParameter( "r" );
	String col = request.getParameter( "c" );
	
	int nRow;
	if( row == null ) { // r 파라미터가 전달되지 않음
		nRow = 3; // 기본 값
	} else {
		nRow = Integer.parseInt( row ); // r파라미터 정수형으로 캐스팅
	}
	
	int nCol;
	if( col == null ) {
		nCol = 3; // 기본 값
	} else {
		nCol = Integer.parseInt( col );
	}	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border='1px' cellspacing='0' cellpadding='10px'>
		<%
		for(int i = 0 ; i < nRow; i++ ) {
			// 행루프
		%>
		<tr>
			<%
			for( int j = 0; j < nCol; j++ ) {
				// 열루프
			%>
			<td>cell(<%=i %>, <%=j %>)</td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>		
	</table>
</body>
</html>