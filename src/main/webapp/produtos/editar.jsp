<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Produto</title>
<style>
	form div {
		margin-bottom: 10px;
	}
</style>
</head>
<body>
	<center>
		<h1>
			Editar Produto:               
			<c:out value="${produto.id}" />
		</h1>
    <div style="color: red;">
      <c:out value="${mensagemErro}" />
    </div>
		<form action="editar" method="POST">
      <input type="hidden" name="id" value="${produto.id}"/>
      <div>
        Nome: <input type="text" name="nome" id="nome" value="${produto.nome}" required>
      </div>
      <div>
        Valor: <input type="number" min="1" name="preco" value="${produto.preco}" id="preco" required>
      </div>
      <div>
        Categoria:
        <select id="categoria" name="categoria" aria-label="Categoria" required value="${produto.categoria.codigo}">
          <option disabled value=""> Selecione </option>
          <c:forEach var="categoria" items="${listaCategoria}">
            <option value="<c:out value='${categoria.codigo}'/>">
              <c:out value="${categoria.nome}" />
            </option>
          </c:forEach>
        </select>
      </div>
      <div> 
        <input type="submit" value="Inserir">
      </div>
		</form>
		<a href="../index.jsp"> Voltar </a>
	</center>
</body>
</html>