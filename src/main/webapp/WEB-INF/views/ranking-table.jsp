<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!-- tag-libs -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
<title>Xếp cặp thi đấu</title>
<%@include file="/WEB-INF/views/include/bootstrap.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="/">Trang
							chủ</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">Vòng đấu</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Vòng đấu trước đó</a>
						</div></li>
				</ul>
			</div>
		</nav>

		<div>
			<form action="">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Tên cờ thủ</th>
							<th scope="col">Quốc tịch</th>
							<th scope="col">Điểm Elo</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${players}" var="player">
							<tr>
								<td>${player.name}</td>
								<td>${player.nationality}</td>
								<td>${player.eloRating}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<button type="submit" class="btn btn-outline-primary">Xếp lịch</button>
			</form>
		</div>
	</div>
</body>
</html>