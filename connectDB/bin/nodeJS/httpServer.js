var http = require("http");

http.createServer(function(req,res){
	res.writeHead(200,{"Content-Type": "text/Plan"});
	res.write("hello~\r\n");
	res.write("world!!\r\n");
	res.end();
}).listen(8080);
