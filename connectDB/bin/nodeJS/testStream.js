var http = require("http");

http.createServer(function(req,res){
	res.writeHead(200,{"Content-Type": "text/Plan"});
	res.write("Hel");
	res.write("lo~\r\n");
	
	
	setTimeout(function(){
		res.write("world!!\r\n");
		res.end();
	},2000);
}).listen(8000);
