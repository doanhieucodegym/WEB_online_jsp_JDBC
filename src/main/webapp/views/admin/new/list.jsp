<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Danh sách  bài viết </title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row" >
                <div class="col-xs-12">
                <div class="row">
                	<div class="col-xs-12">
                		<div class ="table-responsive">
                		 <table class="table table-striped">
							    <thead>
							      <tr>
							        <th>Firstname</th>
							        <th>Lastname</th>
							        <th>Email</th>
							      </tr>
							    </thead>
							    <tbody>
							      <tr>
							        <td>John</td>
							        <td>Doe</td>
							        <td>john@example.com</td>
							      </tr>
							      <tr>
							        <td>Mary</td>
							        <td>Moe</td>
							        <td>mary@example.com</td>
							      </tr>
							      <tr>
							        <td>July</td>
							        <td>Dooley</td>
							        <td>july@example.com</td>
							      </tr>
							    </tbody>
							  </table>
							  <ul class="pagination" id="pagination"></ul>
                		</div>
                	</div>
                </div>

                </div>
            </div>
        </div>
    </div>
</div><!-- /.main-content -->
<script type="text/javascript">
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: 20,
            visiblePages: 5,
            onPageClick: function (event, page) {
                console.info(page + ' (from options)');
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
</script>
</body>
</html>