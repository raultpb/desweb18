<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="./assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="./assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
	MechProject.
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="./assets/css/material-kit.css?v=2.0.3" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="./assets/demo/demo.css" rel="stylesheet" />
</head>

<body class="index-page sidebar-collapse">
  <nav class="navbar navbar-transparent navbar-color-on-scroll fixed-top navbar-expand-lg" color-on-scroll="100" id="sectionsNav">
    <div class="container">
      <div class="navbar-translate">
        <a class="navbar-brand" href="index.html">
          MechProject - Olimp�ada </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
          <span class="navbar-toggler-icon"></span>
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="navbar-nav ml-auto">
          <li class="dropdown nav-item">
            <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
              <i class="material-icons">apps</i> Components
            </a>
            <div class="dropdown-menu dropdown-with-icons">
              <a href="./index.html" class="dropdown-item">
                <i class="material-icons">layers</i> All Components
              </a>
              <a href="https://demos.creative-tim.com/material-kit/docs/2.0/getting-started/introduction.html" class="dropdown-item">
                <i class="material-icons">content_paste</i> Documentation
              </a>
            </div>
          </li>

          <li class="nav-item">
            <a class="nav-link" rel="tooltip" title="Ir para o in�cio da p�gina" data-placement="bottom" href="index.jsp" >
              <i class="fa fa-home"></i>In�cio
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" rel="tooltip" title="Cadastre uma nova Olimp�ada" data-placement="bottom" href="CriarOlimpiada.jsp">
              <i class="fa fa-edit"></i> Cadastrar Olimp�ada
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" rel="tooltip" title="Buscar todas as olimpiadas" data-placement="bottom" href="ListarOlimpiada.jsp">
              <i class="fa fa-search"></i> Buscar/Listar
            </a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <div class="page-header header-filter clear-filter purple-filter" data-parallax="true" style="background-image: url('./assets/img/bg2.jpg');">
    <div class="container">
      <div class="row">
        <div class="col-md-8 ml-auto mr-auto">
          <div class="brand">
            <h1>Olympiad Project.</h1>
            <h3>Inserir medalhas, cadastrar, alterar e exluir olimp�adas.</h3>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="main main-raised">
    <div class="section section-basic">
      <div class="container">
        <div class="title">
          <h2>Criar Nova Olimp�ada</h2>
        </div>
        
                        <!-- Barra superior com os menus de navega��o -->
				
           
                <div id="main" class="container">
                    <form action="controller.do" method="post">
                       
                        <input type="hidden" name="id" value="${olimpiada.id }" />
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="ouro" class="bmd-label-floating">Insira as medalhas de OURO</label>
                                <input type="text" class="form-control" name="ouro" id="ouro" required maxlength="5" value="${olimpiada.ouro}">
                            </div>
                        
                     	 
                            <div class="form-group col-md-4">
                               <label for="prata" class="bmd-label-floating">Insira as medalhas de PRATA</label>
                                <input type="number" class="form-control" name="prata" id="prata" maxlength="5"  value="${olimpiada.prata}">
                            </div>

                            <div class="form-group col-md-4">
                               <label for="bronze" class="bmd-label-floating">Insira as medalhas de BRONZE</label>
                                <input type="number" class="form-control" name="bronze" id="bronze" required maxlength="5"  value="${pais.bronze }">
                            </div>
                        </div>
                        
                         <div class="row">
	                        <div class="form-group col-md-4">
	                        
	                        
	                         <!-- LABEL ANTIGA! <label for="nomePais">Nome do Pa�s</label> --> 
	                         <label for="nomePais" class="bmd-label-floating">Nome do Pa�s</label>      
	                                <input type="text" class="form-control" name="nomePais" id="nomePais" required maxlength="20"  value="${olimpiada.nomePais}">
	                        </div>
	                            
	                         <div class="form-group col-md-4">
	                                <label for="nomeModalidade" class="bmd-label-floating">Modalidade</label>
	                                <input type="text" class="form-control" name="nomeModalidade" id="nomeModalidade" required maxlength="20" value="${olimpiada.nomeModalidade}">
	                         </div>
	                         <div class="form-group col-md-4">
	                                <label for="ano" class="bmd-label-floating">Ano</label>
	                                <input type="text" class="form-control" name="ano" id="ano" required maxlength="5"  value="${olimpiada.ano}">
	                         </div>
	                        <hr />
	                        
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="command"
						value="CriarOlimpiada">Salvar</button>
					<a href="index.jsp" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</div>
<div class="sharing-area text-center">
          <button id="home" class="btn btn-raised btn-warning btn-round">
            <i class="fa fa-home"></i>Ir para o In�cio
          </button>
          
        </div>
      </div>
    </div>
  </div>
  <!--  End Modal -->
  <footer class="footer" data-background-color="black">
    <div class="container">
      <nav class="float-left">
        <ul>
          <li>
            <a href="index.jsp">
              MechProject.
            </a>
          </li>
          <li>
            <a href="index.jsp">
              Sobre
            </a>
		</li>
        </ul>
      </nav>
      <div class="copyright float-right">
        &copy;
        <script>
          document.write(new Date().getFullYear())
        </script>, desenvolvido por <i class="material-icons">fingerprint</i> 
        <a href="index.jsp" target="_blank">Raul Machado</a> para Desenvolvimento Web.
      </div>
    </div>
  </footer>
  <!--   Core JS Files   -->
  <script src="./assets/js/core/jquery.min.js" type="text/javascript"></script>
  <script src="./assets/js/core/popper.min.js" type="text/javascript"></script>
  <script src="./assets/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>
  <script src="./assets/js/plugins/moment.min.js"></script>
  <!--	Plugin for the Datepicker, full documentation here: https://github.com/Eonasdan/bootstrap-datetimepicker -->
  <script src="./assets/js/plugins/bootstrap-datetimepicker.js" type="text/javascript"></script>
  <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
  <script src="./assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
  <!-- Control Center for Now Ui Kit: parallax effects, scripts for the example pages etc -->
  <script src="./assets/js/material-kit.js?v=2.0.3" type="text/javascript"></script>
  <script>
    $(document).ready(function() {
      //init DateTimePickers
      materialKit.initFormExtendedDatetimepickers();

      // Sliders Init
      materialKit.initSliders();
    });


    function scrollToDownload() {
      if ($('.section-download').length != 0) {
        $("html, body").animate({
          scrollTop: $('.section-download').offset().top
        }, 1000);
      }
    }
  </script>
  </body>
</html>
