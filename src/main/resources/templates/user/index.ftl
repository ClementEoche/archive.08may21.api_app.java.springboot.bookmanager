<#include "../bases/importbase.ftl"/>
<div class="m-4">
	<h1>The Books Manager</h1>
	<div class="jumbotron p-3">
		<div class="d-flex flex-row-reverse mb-4">
			<a class="p-2" href="/user/create"> 
				<button class="btn btn-success">
					Create User
				</button>
			</a>
			<a class="p-2" href="/book/create"> 
				<button class="btn btn-success">
					Create Book
				</button>
			</a>
			<a class="p-2" href="/book/index"> 
				<button class="btn btn-warning">
					Watch All Books
				</button>
			</a>
		</div>
		<div class="row lg-col-12 p-2">
		  
		    <div class="col-3">
		      	Name
		    </div>
		    <div class="col-3">
		    	Role
		    </div>
		    <div class="col-4">
		    	Connexion
		    </div>
		    <div class="col-2">
		    </div>
		    
		 </div>
		<#list items as item>
		  <div class="row lg-col-12 p-2">
		  
		    <div class="col-3">
		      	${item.firstname} ${item.lastname}
		    </div>
		    <div class="col-3">
		    	${item.role}
		    </div>
		    <div class="col-4">
		    	<a href="../useraccess/login/${item.id}"><button class="btn btn-info">Connect as this user</button></a>
		    </div>
		    <div class="col-2">
		      <a href="/user/details/${item.id}"><button class="btn btn-info">Details</button></a>
		    </div>
		    
		  </div>
		</#list>
	</div>
</div>