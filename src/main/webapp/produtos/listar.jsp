<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Produtos </title>
<style>
  form div {
    margin-bottom: 10px;
  }
</style>
</head>
<body>
    <center>
    <c:if test="${not empty codigoCategoria}">
      <h1> Produtos da Categoria: <c:out value="${codigoCategoria}" /> </h1>
    </c:if>
    <div align="center">
      <h2>Lista de Produtos</h2>
      <c:if test="${empty codigoCategoria}">
        <h2>
          <a href="inserir"> Adicionar produto </a>
        </h2>

		    <form action="pesquisar" method="GET" style="margin: 30px;">
          <input type="text" name="nome" />
          <button type="submit"> Pesquisar </button>
        </form>
      </c:if>

      <table border="1" cellpadding="5">
          <tr>
              <th>ID</th>
              <th>Nome</th>
              <th>Categoria</th>
              <th>Preço</th>
              <c:if test="${empty codigoCategoria}">
                <th>Ações</th>
              </c:if>

          </tr>
          <c:forEach var="produto" items="${listaProdutos}">
              <tr>
                <td><c:out value="${produto.id}" /></td>
                <td><c:out value="${produto.nome}" /></td>                   
                <td><c:out value="${produto.categoria.nome}" /></td>                   
                <td><c:out value="${produto.preco}" /></td>      
                <c:if test="${empty codigoCategoria}">
                  <td>
                    <a href="editar?id=<c:out value='${produto.id}' />">Alterar</a>
                    <br/>
                    <br/>
                    <a href="deletar?id=<c:out value='${produto.id}' />">Deletar</a>                    	
                  </td>
                </c:if>        
              </tr>
          </c:forEach>
      </table>
  </div>
		<a href="../index.jsp"> Voltar </a>
	</center>
</body>
</html>