puts = require("sys").puts;

setInterval(function(){
	puts("hellow");
},500);

process.addListener("SIGINT",function(){
	puts("good-by");
	process.exit(0);
});
