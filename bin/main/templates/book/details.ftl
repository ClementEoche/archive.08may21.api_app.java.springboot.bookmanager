<#include "../bases/importbase.ftl"/>
<div class="m-4">
	<a class="p-2" href="/user/index"> 
			<button class="btn btn-danger">
				Back
			</button>
	</a>
	<h1>Details of book ${item.id}</h1>
	<div class="jumbotron p-3">
		<div>
			<label>Book Name : </label>
			<label>${item.name}</label>
		</div>
		<div>
			<label>Nb Pages : </label>	
			<label>${item.nbPage}</label>
		</div>
		<div>
			<label>Price : </label>
			<label>${item.price}</label>
		</div>
		<div>
			<label>Owner : </label>	
			<#if  item.user?has_content>
				<label>${item.user}</label>
			<#else>
				<label>Not owned</label>
			</#if>
		</div>
	</div>
</div>