<#include "../bases/importbase.ftl"/>
<div class="m-4">
	<a class="p-2" href="/user/index"> 
			<button class="btn btn-danger">
				Logout
			</button>
		</a>
		<h3>Filters</h3>
		<a type="button" class="btn btn-info" href="/useraccess/login/${user.id}/findbynbpages">By number of pages</a>
		<a type="button" class="btn btn-info" href="/useraccess/login/${user.id}/priceSearch">By price</a>


	<h1>My Books : </h1>
	<div class="row jumbotron">
		<#if  mybooks?has_content>
			<#list mybooks as mybook>
				<div class="card" style="width: 13rem; margin:1rem; padding:1rem;">
				  <img class="card-img-top" src="/img/open-book.png" alt="Card image cap">
				  <div class="card-body">
				    <h5 class="card-title">${mybook.name}</h5>
				    <p class="card-text">That's a nice book for ${mybook.price}$</p>
				    <a href="/book/details/${mybook.id}" class="btn btn-info">Detail</a>
				  </div>
				</div>
			</#list>				
		<#else>
			<label>No Books owned</label>
		</#if>	
	</div>
	<h1>Books available : </h1>
	<div class="row jumbotron">
		<#if  books?has_content>
			<#list books as book>
				<div class="card" style="width: 13rem; margin:1rem; padding:1rem;">
				  <img class="card-img-top" src="/img/open-book.png" alt="Card image cap">
				  <div class="card-body">
				    <h5 class="card-title">${book.name}</h5>
				    <p class="card-text">that's ${book.price} only bro</p>
				    <a href="/book/details/${book.id}" class="btn btn-info">Detail</a>
				    <a href="/useraccess/login/${user.id}/takebooks/${book.id}" class="btn btn-success">Buy</a>
				  </div>
				</div>
			</#list>				
		<#else>
			<label>No Books available</label>
		</#if>	
	</div>
</div>