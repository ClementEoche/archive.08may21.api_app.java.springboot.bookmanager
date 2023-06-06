<#include "../bases/importbase.ftl"/>
<div class="m-4">
	<a class="p-2" href="/useraccess/login/${user.id}"> 
			<button class="btn btn-danger">
				Back
			</button>
	</a>
	<h1>My Books free to take</h1>
	<div class="jumbotron row">
		<#if  books?has_content>
			<#list books as book>
				<div class="card" style="width: 13rem; margin:1rem; padding:1rem;">
				  <img class="card-img-top" src="/img/open-book.png" alt="Card image cap">
				  <div class="card-body">
				    <h5 class="card-title">${book.name}</h5>
				    <p class="card-text">That's a nice book</p>
				    <a href="/useraccess/login/${user.id}/takebooks/${book.id}" class="btn btn-warning">Take</a>
				  </div>
				</div>
			</#list>				
		<#else>
			<label>No Books</label>
		</#if>	
	</div>
</div>