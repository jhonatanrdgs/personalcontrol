<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
  <div class="container-fluid">

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      	<li class="menu"><a href="<c:url value="/logged"/>">P�gina Inicial</a></li>
     	<li class="dropdown menu">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Cadastros Gerais<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="<c:url value="/categoria/listCategoria" />">Categorias</a></li>
            <li class="divider"></li>
            <li><a href="<c:url value="/rendimento/listRendimento" />">Rendimentos</a></li>
            <li class="divider"></li>
            <li><a href="<c:url value="/metodoPagamento/listMetodosPagamento" />">M�todos de Pagamento</a></li>
          </ul>
        </li>
        <li class="menu"><a href="<c:url value="/despesa/listDespesas" />">Despesas<span class="sr-only">(current)</span></a></li>
        <li class="menu"><a href="<c:url value="/adiantamento/iniciar" />">Adiantamento de Parcelas</a></li>
        <li class="menu"><a href="<c:url value="/despesaCarro/listDespesaCarro" />">Despesas Carro</a></li>
         <li class="menu"><a href="<c:url value="/simulacao/iniciar" />">Simula��o</a></li>
        <li class="menu"><a href="<c:url value="/relatorios/iniciar" />">Relat�rios</a></li>
        <li class="menu"><a href="<c:url value="/relatorioPDF" />">Relat�rios PDF</a></li>
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <li><a  href="<c:url value="/j_spring_security_logout" />">Sair</a></li>
        
      </ul>
    </div>
  </div>
</nav>