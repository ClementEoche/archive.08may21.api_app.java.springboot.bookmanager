<#include "../bases/importbase.ftl"/>
<div class="m-4">
	<a class="p-2" href="/useraccess/login/${user.id}"> 
			<button class="btn btn-danger">
				Back
			</button>
	</a>
	<h1>Books creation by ${user.firstname}<h1>
	<h4 class="text-success">The book will be directly added to your collection</h4>
	<div class="jumbotron">
		<form method="POST">
			<label for="name">Book Name</label>
			<input type="text" id="name" name="name"/>
			<label for="name">Book Pages</label>
			<input type="number" id="nbPage" name="nbPage"/>
			<label for="name">Book Price</label>
			<input type="number" id="price" name="price"/>
			<input type="submit" value="Create"/>
		</form>
	</div>
</div>