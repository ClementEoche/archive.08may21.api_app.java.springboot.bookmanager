<#include "../bases/importbase.ftl"/>
<div class="m-4">
	<a class="p-2" href="/user/index"> 
			<button class="btn btn-danger">
				Back
			</button>
	</a>
	<h1>Books creation<h1>
	<h4 class="text-danger">You're not log as user the book will be own by nobody</h4>
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