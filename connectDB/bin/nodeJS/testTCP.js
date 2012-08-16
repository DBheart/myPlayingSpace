var tcp = require("net");

var s = tcp.createServer();
s.addListener("connection",function(c){
	c.write("hello!");
	c.end();
});

s.listen(8000);
