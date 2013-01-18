define(function() {
	
	var constant = [];
    var hashes = urlArgs.split('&');
    for(var i = 0; i < hashes.length; i++) { 
        var hash = hashes[i].split('=');
        constant.push(hash[0]);
        constant[hash[0]] = hash[1]; 
    }

	return constant;
});