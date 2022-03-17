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
		<h1> Produtos da Categoria: <c:out value="${codigoCategoria}" /> </h1>
    <div align="center">
      <table border="1" cellpadding="5">
          <caption><h2>Lista de Categorias</h2></caption>
          <tr>
              <th>ID</th>
              <th>Nome</th>
              <th>Preço</th>
              <th>Ações</th>
          </tr>
          <c:forEach var="produto" items="${listaProdutos}">
              <tr>
                <td><c:out value="${produto.id}" /></td>
                <td><c:out value="${produto.nome}" /></td>                   
                <td><c:out value="${produto.preco}" /></td>      
                <td>
                  <a href="editar?id=<c:out value='${produto.id}' />">Alterar</a>
                  <br/>
                  <br/>
                  <a href="deletar?id=<c:out value='${produto.id}' />&categoria=<c:out value='${codigoCategoria}' />">Deletar</a>                    	
                </td>             
              </tr>
          </c:forEach>
      </table>
  </div>
		<a href="../index.jsp"> Voltar </a>
	</center>
</body>
</html>