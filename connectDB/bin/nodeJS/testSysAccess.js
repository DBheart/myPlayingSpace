var sys = require("sys");
	spwan = require("child_process").spawn;
	
var ls = spwan("ls",["-ls","/"]);

ls.stdout.addListener("data",function(){
	sys.print(data);
});
	
