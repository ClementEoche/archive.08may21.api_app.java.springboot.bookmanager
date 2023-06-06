<#include "../bases/importbase.ftl"/>
<div>
<a class="p-2" href="/user/index"> 
			<button class="btn btn-danger">
				my brain is fcked up
			</button>
	</a>
		<div class="jumbotron lg-col-12">
			<h6>Search for books by page numbers</h6>
			<form class="pt-2" method="POST">
				<div class="form-group">
					<div class="form-row">
						<div class="col-12 form-check form-check-inline">
							<div class="text-center pb-1">
						    		<input class="form-check-input" type="radio" id="pageless" value="less" name="filter" checked>
									<label class="form-check-label" for="pageless"> =< </label>

						    		<input class="form-check-input" type="radio" id="pagemore" value="more" name="filter">
									<label class="form-check-label" for="pagemore"> => </label>
							</div>
						</div>
						<div class="col-12">
							<input id="filter" name="paj" type="number" step="10" class="form-control" aria-label="Search">
						</div>
						<div class="col-12 mt-1 text-center">
							<input type="submit" class="btn btn-success" value="Search"/>
						</div>
				    </div>
			    </div>
			 </form>
		</div>


	<#if books?has_content>
		<div class="jumbotron">
				<p class="h5">Books available with <span class="text-success">${paj}</span> pages or ${option}</p>
				<div class="row">
					<div class="card-group">
						<#list books as book>
							<div class="card ">
							  <img class="card-img-top" src="/img/open-book.png" alt="Book icon">
							  <div class="card-body">
							    <h5 class="card-title">${book.name}</h5>
							    <p class="card-text">${book.price} $</p>
							    <p class="card-text">${book.nbPage} pages</p>
							  </div>
								<div class="card-footer">
									<p>Current owner:</p>
							      	<p>
							      	<#if book.user??>
									  ${book.user.getFirstname()} ${book.user.getLastname()}
									<#else>
										N/A
									</#if>
							      	</p>
							      	<a href="/useraccess/login/${user.id}/takebooks/${book.id}" class="btn btn-success btn-sm"/>Buy this book</a>
							    </div>

							</div> 
						</#list>
					</div>
				</div>
			</div>

	<#else>
	<p>Books hate u</p>
	</#if>
</div>