define([
  "debug",
  "common/util",
  "common/inherit",
  "app/contact/api/ContactAddressApi"
],function(debug, util, inherit, api) {

	var AddressGrid = inherit(
		Object,
		function(){
			this.name = "AddressGrid";
			
			var names = colNames();
			var models = colModel();
			
			var $grid = this.$grid = $("#address_grid");
			
			$grid.jqGrid({
				datatype : "json",
				height: 100, 
				width: 450,
				mtype: "GET", 
				colNames : names,
				colModel : models,
				rowNum : 10,
				rowList:[10,20,30],
				sortname: models[0].name,
				sortorder: "asc",
				hoverrows : false,
				loadonce : false,
				viewrecords: true,
				shrinkToFit : false,
				loadui : "block",
				gridview: true,
				pager: "#address_grid_pager",
				onSelectRow : function(row) {
					$grid.jqGrid('GridToForm', row, "#address_form");
				}
			});
			
			$grid
			.jqGrid("navGrid","#address_grid_pager",{search:false,edit:false,add:false,del:false}); 
		},
		{
			reload : function(param) {
				debug.assert(typeof param.contactId != "undefined");
				
				this.$grid.setGridParam({
					url : api.getAddressURL(param.contactId) + "/grid",
					postData : {
						contactId : param.contactId
					}
				}).trigger("reloadGrid");
			}
		}
	);
	
	function colNames() {
		return ["Address Type", "Street And Number", "Zip Code", "City"];
	}
	
	function colModel() {
		return [
		        {name:"addressType",index:"addressType", width:100},
		        {name:"streetAndNumber",index:"streetAndNumber", width:120},
		        {name:"zipCode",index:"zipCode", width:100},
		        {name:"city",index:"city", width:100}
		        ];
	}
	
	return AddressGrid;
});