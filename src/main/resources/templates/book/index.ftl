<#include "../bases/importbase.ftl"/>
<div class="m-4">
	<a class="p-2" href="/user/index"> 
			<button class="btn btn-danger">
				Back
			</button>
	</a>
	<h1>List of all the Books</h1>
	<div class="jumbotron p-3">
		<#list items as item>
				<div class="row lg-col-12 p-2">
					<div class="col-4">
						${item.name}
					</div>
					<div class="col-4">
				      <a href="/book/details/${item.id}"><button class="btn btn-info">Details</button></a>
				    </div>
				</div>	
		</#list>
	</div>
</div>