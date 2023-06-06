<#include "../bases/importbase.ftl"/>
<!-- <#if errors??>
${errors}
</#if>
<#if moncookie??>
${moncookie}
</#if>-->
<div class="m-4">
	<a class="p-2" href="/user/index"> 
			<button class="btn btn-danger">
				Back
			</button>
	</a>
	<h1>User creation<h1>
	<h4 class="text-danger">If you choose a role different than seller or customer you will not be able to interact with books</h4>
	<div class="jumbotron lg-col-12">
		<form method="POST" class="form-groupe col-4">
		  <label for="firstname">Firstname</label>
		  <input class="form-control" type="text" id="firstname" name="firstname"/>
		  <label for="lastname">Lastname</label>
		  <input class="form-control" type="text" id="lastname" name="lastname"/>
		  <#include "./roleSelection.ftl">
		  <input type="submit" value="Create"/>
		</form>
	</div>
</div>