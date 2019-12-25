//this script to get data from web voca.vn
//for example : https://www.voca.vn/blog/tu-vung-tieng-anh-ve-cong-so-1195

function getValue(iCover, iP) {
	return document.querySelectorAll(".item-cover")[iCover]
			.querySelectorAll("p")[iP].innerText;
}

var length = document.querySelectorAll(".item-cover").length;
console.log("{ \"lst\":[");
for (var i = 0; i < length; i++) {
	var word = {
		eng : getValue(i, 0),
		type : getValue(i, 1),
		vn : getValue(i, 2),
		example : getValue(i, 4)
	};
	console.log(JSON.stringify(word) + ",");
}
console.log("]}");