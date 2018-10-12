<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>转账界面</title>
</head>
<body>
	<center>
		<form action="${pageContext.request.contextPath }/transfer" method="post">
			<table align="center" style="width: 300px;height: 200px; text-align: center; border: 1px solid;">
				<p style="text-align: center;margin-top: 20px;">转出业务</p>
				<tr style="height: 50px;">
					<td>
						转出账户:
					</td>
					<td>
						<input type="text" value="" name="out">
					</td>
				</tr>
				<tr style="height: 50px;">
					<td>
						转入账户:
					</td>
					<td>
						<input type="text" value="" name="in">
					</td>
				</tr>
				<tr style="height: 50px;">
					<td>
						转出金额:
					</td>
					<td>
						<input type="text" value="" name="money">
					</td>
				</tr>
				<tr style="height: 50px;">
					<td>
						<input type="submit" value="确认转账">
					</td>
					<td>
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>