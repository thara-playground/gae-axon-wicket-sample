define(function() {
	var inheret = {};

	var inherit = function(parent, init, proto) {
		var child = function(o) {
			for (var p in o) {this[p] = o[p];}
			init.apply(this, []);
		};
		child._init_ = init;
		child.prototype = new parent;
		for ( var p in proto) child.prototype[p] = proto[p];
		return child;
	};

	return inherit;
});