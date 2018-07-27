<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- #section:basics/navbar.layout -->
<div id="navbar" class="navbar navbar-default navbar-collapse">
	<script type="text/javascript">
		try {
			ace.settings.check('navbar', 'fixed')
		} catch (e) {
		}
	</script>

	<div class="navbar-container" id="navbar-container">
		<!-- #section:basics/sidebar.mobile.toggle -->
		<button type="button" class="navbar-toggle menu-toggler pull-left"
			id="menu-toggler" data-target="#sidebar">
			<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>

			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>

		<!-- /section:basics/sidebar.mobile.toggle -->
		<div class="navbar-header pull-left">
			<!-- #section:basics/navbar.layout.brand -->
			<a href="index" class="navbar-brand"> <small> <i
					class="fa fa-inbox bigger-110"></i> <spring:message
						code="common.appname" />
			</small>
			</a>

			<!-- /section:basics/navbar.layout.brand -->

			<!-- #section:basics/navbar.toggle -->
			<button class="pull-right navbar-toggle navbar-toggle-img collapsed"
				type="button" data-toggle="collapse" data-target=".navbar-buttons">
				<span class="sr-only">Toggle user menu</span> <img
					src="../assets/avatars/avatar2.png" alt="Jason's Photo" />
			</button>

			<!-- /section:basics/navbar.toggle -->
		</div>

		<!-- #section:basics/navbar.dropdown -->
		<div
			class="navbar-buttons navbar-header pull-right  collapse navbar-collapse"
			role="navigation">
			<ul class="nav ace-nav">
				<li class="transparent"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#"> <i
						class="ace-icon fa fa-bell icon-animated-bell"></i>
				</a>

				<!-- #section:basics/navbar.user_menu -->
				<li class="light-blue"><a data-toggle="dropdown" href="#"
					class="dropdown-toggle"> <img class="nav-user-photo"
						src="assets/avatars/user.jpg" alt="Jason's Photo" /> <span
						class="user-info"> <small>Welcome,</small> York
					</span> <i class="ace-icon fa fa-caret-down"></i>
				</a>

					<ul
						class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li><a href="index"> <i class="ace-icon fa fa-cog"></i>
								Settings
						</a></li>

						<li><a href="index"> <i class="ace-icon fa fa-user"></i>
								Profile
						</a></li>

						<li class="divider"></li>

						<li><a href="index"> <i class="ace-icon fa fa-power-off"></i>
								Logout
						</a></li>
					</ul></li>

				<!-- /section:basics/navbar.user_menu -->
			</ul>
		</div>

		<!-- /section:basics/navbar.dropdown -->
	</div>
	<!-- /.navbar-container -->
</div>
