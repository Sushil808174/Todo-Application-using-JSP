<%@ include file="Common/header.jspf" %>
<%@ include file="Common/navigation.jspf" %>

<div class="container">
	<h1>Enter Todo Details </h1>
	
	<form:form method="post" modelAttribute="todo">
		
		<fieldset class="mb-3">
			<from:label for="description">Description</from:label>
			<form:input type="text" path="description" />
			<form:errors path="description" cssClass="text-warning"/>
		</fieldset>
		
		<fieldset class="mb-3">
			<from:label for="localDate">Target Date</from:label>
			<form:input type="text" path="localDate" />
			<form:errors path="localDate" cssClass="text-warning"/>
		</fieldset>
		
		<form:input type="hidden" path="id" />
		<form:input type="hidden" path="done" />
		<input type="submit" value="Submit" class="btn btn-success" />
	</form:form>
	
</div>

<%@ include file="Common/footer.jspf" %>
<script type="text/javascript">
	$('#localDate').datepicker({
		format: 'dd/mm/yyyy'
	});
</script>