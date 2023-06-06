<#include "../bases/importbase.ftl"/>
<div class="m-4">
	<h1>My Books for sale</h1>
	<div class="mb-2">
		<a class="p-2" href="/useraccess/login/${user.id}/takebooks"> 
			<button class="btn btn-warning">
				Take a Book and sell it
			</button>
		</a>
		<a class="p-2" href="/useraccess/login/${user.id}/create"> 
			<button class="btn btn-success">
				Create a book
			</button>
		</a>
		<a class="p-2" href="/user/index"> 
			<button class="btn btn-danger">
				Logout
			</button>
		</a>
	</div>
	<div class="row jumbotron">
		<#if  books?has_content>
			<#list books as book>
				<div class="card" style="width: 13rem; margin:1rem; padding:1rem;">
				  <img class="card-img-top" src="/img/open-book.png" alt="Card image cap">
				  <div class="card-body">
				    <h5 class="card-title">${book.name}</h5>
				    <p class="card-text">That's a nice book</p>
				    <a href="/book/details/${book.id}" class="btn btn-info">Detail</a>
				  </div>
				</div>
			</#list>				
		<#else>
			<label>No Books</label>
		</#if>	
	</div>
</div>