const form = document.getElementById("form");
const form_button_submit = document.getElementById('form_button_submit');
const oneClickEnter = document.getElementById('oneClickEnter');

const mi_account = document.getElementById('mi_account');
const mi_password = document.getElementById('mi_password');
const mi_name = document.getElementById('mi_name');
const mi_id = document.getElementById('mi_id');
const mi_birth = document.getElementById('mi_birth');
const mi_phone = document.getElementById('mi_phone');
const mi_email = document.getElementById('mi_email');
const mi_address = document.getElementById('mi_address');

// trim to remove the whitespaces
const mi_accountValue = mi_account.value.trim();
const mi_passwordValue = mi_password.value.trim();
const mi_nameValue = mi_name.value.trim();
const mi_idValue = mi_id.value.trim();
const mi_birthValue = mi_birth.value.trim();
const mi_phoneValue = mi_phone.value.trim();
const mi_emailValue = mi_email.value.trim();
const mi_addressValue = mi_address.value.trim();


/*送出資料*/
form_button_submit.addEventListener('click', e => {
	e.preventDefault();
	if(!checkInputsError()){
		form.submit(); /* 如果沒有error，就執行送出*/
	}
});

/*一鍵輸入*/
oneClickEnter.addEventListener('click', e => {
	e.preventDefault();
	oneClickToEnter();
}); 


/*送出時進行資料確認*/
const isFalse = (element) => element === false;

function checkInputsError() {
	let checkSuccess;
	
	checkSuccess = [oninputCheckAccount(),
					oninputCheckPassword(),
					oninputCheckName(),
					oninputCheckId(),
					oninputCheckBirth(),
					oninputCheckPhone(),
					oninputCheckEmail(),
					oninputCheckAddress()]
	console.log(checkSuccess);
	return checkSuccess.some(isFalse);  /*翻譯: 陣列中有沒有false?*/
	// some 裡面放方法, 會把 array(eg.checkSuccess) 裡面的東西一個一個放到 some 括號內的方法中
	// array 中有任何滿足 some 中方法(eg.isFalse)的條件, some 就回傳 true(對，陣列中有false)
}

 
//驗證帳號
function verifyAccount(){
	
}

function oninputCheckAccount(){
	//確認帳號
	let mi_accountValue = mi_account.value.trim();
	console.log(mi_accountValue); 
	if(mi_accountValue === '') {
		setErrorFor(mi_account, '帳號不能為空');
		return false;
	} else {
		setSuccessFor(mi_account);
		return true;
	}
}



//驗證password的正規表達式
function verifyPassword (mi_passwordValue) {
	//最少八個字符，至少一個大寫字母，一個小寫字母和一個數字
	let regex = new RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/g)
	verification = regex.test(mi_passwordValue)
	return verification
}
	
function oninputCheckPassword(){
	//確認密碼
	let mi_passwordValue = mi_password.value.trim();
	if(mi_passwordValue === '') {
		setErrorFor(mi_password, '密碼不能為空');
		return false;
	} else if(verifyPassword(mi_passwordValue) === false){
		setErrorFor(mi_password, '密碼格式錯誤，請重新輸入');
		return false;
	} else {
		setSuccessFor(mi_password);
		return true;
	}
}

//驗證姓名
function oninputCheckName(){
	//確認姓名
	let mi_nameValue = mi_name.value.trim();
	if(mi_nameValue === '') {
		setErrorFor(mi_name, '姓名不能為空');
		return false;
	} else {
		setSuccessFor(mi_name);
		return true;
	}
}


	
 //驗證id
function verifyId(id) {
	//建立字母分數陣列(A~Z)
	var city = new Array(1,10,19,28,37,46,55,64,39,73,82, 2,11,20,48,29,38,47,56,65,74,83,21, 3,12,30)
	id = id.trim().toUpperCase();
	//使用「正規表達式」檢驗格式
	if (id.search(/^[A-Z](1|2)\d{8}$/i) == -1) {
	    return false;
	} else {
	    //將字串分割為陣列(IE必需這麼做才不會出錯)
	    id = id.split('');
	    //計算總分
	    var total = city[id[0].charCodeAt(0)-65];
	    for(var i=1; i<=8; i++){
	        total += eval(id[i]) * (9 - i);
	    }
	    //補上檢查碼(最後一碼)
	    total += eval(id[9]);
	    //檢查比對碼(餘數應為0);
	    return ((total%10 == 0 ));
	}
}
 
function oninputCheckId(){
	let mi_idValue = mi_id.value.trim();
	//確認id
	if(mi_idValue === ''){
		setErrorFor(mi_id, '身分證字號不能為空');
		return false;
	}else if(verifyId(mi_idValue) === false) {
		setErrorFor(mi_id, '您的身分證不合法，請重新輸入');
		return false;
	}else {
		setSuccessFor(mi_id);
		return true;
	}
}

 
 //驗證生日
 function verifyBirth(mi_birthValue){
	let today = new Date().getTime();  //獲得自1970年到當前時間之間的秒數
	let mi_birth = new Date(mi_birthValue); //取得user輸入的生日
	//console.log(mi_birth.getTime());  //取得user生日自1970算到現在的秒數
	if(mi_birth>today){
		return false;
	}else{
		return true;
	}

}
 
 function oninputCheckBirth(){
	//確認生日
	let mi_birthValue = mi_birth.value.trim();
	if(mi_birthValue === ''){
		setErrorFor(mi_birth, '生日不能為空');
		return false;
	}else if(verifyBirth(mi_birthValue) === false){
		setErrorFor(mi_birth, '生日不能大於今天');
		return false;
	}else{
		setSuccessFor(mi_birth);
		return true;
	}
}
 
 //驗證電話的正規表達式
function verifyPhone(phone) {
	let regex = new RegExp(/^09[0-9]{8}$/g) //規則:09開頭，後面接著8個0~9的數字
	phone = phone.trim();
	verification = regex.test(phone)  
	return verification
}
 
function oninputCheckPhone(){
	//確認電話
	let mi_phoneValue = mi_phone.value.trim();
	if(mi_phoneValue === ''){
		setErrorFor(mi_phone, '電話不能為空');
		return false;
	}else if(verifyPhone(mi_phoneValue) === false) {
		setErrorFor(mi_phone, '電話號碼格式錯誤，請重新輸入');
		return false;
	}else{
		setSuccessFor(mi_phone);
		return true;
	}
}
 
 
//驗證email的正規表達式
function verifyEmail(email) {
	let regex = new RegExp(/^([A-Za-z0-9_\-\.]+)@([A-Za-z0-9_\-\.]+)\.([A-Za-z]{2,6})$/g)
	email = email.trim();
    verification = regex.test(email)  //規則:任意字符(包括英文數字_-.)無限個  + @ + 任意字符無限個 + . + 二至六位英文字母
	return verification
}
 
function oninputCheckEmail(){
	//確認Email
	let mi_emailValue = mi_email.value.trim();
	if(mi_emailValue === '') {
		setErrorFor(mi_email, 'Email不能為空');
		return false;
	} else if (verifyEmail(mi_emailValue) === false) {
		setErrorFor(mi_email, '無效Email，請重新輸入');
		return false;
	} else {
		setSuccessFor(mi_email);
		return true;
	}
} 
 
function oninputCheckAddress(){
	//確認地址
	let mi_addressValue = mi_address.value.trim();
	if(mi_addressValue === '') {
		setErrorFor(mi_address, '地址不能為空');
		return false;
	} else {
		setSuccessFor(mi_address);
		return true;
	}
}
 
/* 塞錯誤訊息 */ 
function setErrorFor(input, message) {
	const formControl = input.parentElement;
	const small = formControl.querySelector('small');
	formControl.className = 'form-control error';
	small.innerText = message;
}

/* 塞正確訊息 */
function setSuccessFor(input) {
	const formControl = input.parentElement;
	formControl.className = 'form-control success';
}
 
 /* 執行一鍵輸入*/
function oneClickToEnter(){
	/* 取消變顏色*/
	let errorNodes = document.getElementsByClassName('form-control error');
	let successNodes = document.getElementsByClassName('form-control success');
	for(let i = 0 ; i<errorNodes.length ; i++){
		errorNodes[i].className = 'form-control'
	}
	
	for(let i = 0 ; i<successNodes.length ; i++){
		successNodes[i].className = 'form-control'
	}
	
	/*塞入值到input框*/
	mi_account.value = randomAccount();
	mi_password.value = 'Password1';
	mi_name.value = randomName();
	mi_id.value = randomId();
	mi_birth.value = '1999-01-10';
	mi_phone.value = '0987993557';
	mi_email.value = 'email@mail.com';
	mi_address.value = '桃園市中壢區新生路二段421號';
	
	/* 重新把success加上去 */
	let nodes = document.getElementsByClassName('form-control');
	for(let i = 0 ; i<nodes.length ; i++){
		nodes[i].className = 'form-control success'
	}
	
}
 
 /*產生隨機帳號*/
 function randomAccount(){
	let code="";
	let codeLength = Math.floor(Math.random()*6)+8;//隨機產生驗證碼的長度0-5碼再加8 -> 產生8-13碼	
	let random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');//隨機數 
	for(let i = 0; i < codeLength; i++  ) {//迴圈操作 
		let index = Math.floor(Math.random()*36);//取得隨機數的索引（0~35） 
		code  += random[index];//根據索引取得隨機數加到code上 
	} 
	return code;
}

/*產生隨機姓名*/
function randomName(){
	let familyNames = new Array(
	"王", "陳",  "林", "許", "張" , "蔡", "李", "黃", "吳", "蔡", 
	"鄭", "楊", "劉" , "郭", "許", "洪", "邱", "曾", "周", "謝"
	);
	
	let givenNames = new Array(
	"家豪", "志明", "俊傑", "冠宇", "承翰", "志偉", "志成", "國華", "冠霖", "宇翔",
	 "淑娟", "淑芬", "美玲", "雅婷", "美惠", "麗華", "怡君", "美玉", "麗美", "秀玲"
	);
	let i = Math.floor(Math.random()*12); //隨機在0-12中選一個數
	let familyName = familyNames[i];
	let givenName = givenNames[i];
	let name = familyName + givenName;
	return name
}

/*隨機產生身分證*/
function randomId(){
	let city = new Array(
         1,10,19,28,37,46,55,64,39,73,82, 2,11,
        20,48,29,38,47,56,65,74,83,21, 3,12,30
    )
    //建立隨機身份證碼
    let id = new Array();
    id[0] = String.fromCharCode(Math.floor(Math.random() * (26)) + 65);
    id[1] = Math.floor(Math.random() * (2)) + 1;
    for(let i=2; i<9; i++){
        id[i] = Math.floor(Math.random() * (9)) + 0;
    }
    //計算總分
    let total = city[id[0].charCodeAt(0)-65];
    for(let i=1; i<=8; i++){
        total += eval(id[i]) * (9 - i);
    }
    //計算最尾碼
    let total_arr = (total+'').split('');
    let lastChar = eval(10-total_arr[total_arr.length-1]);
    let lastChar_arr = (lastChar+'').split('');
    //補上最後檢查碼
    id[id.length++] = lastChar_arr[lastChar_arr.length-1];
    //回傳結果
    return id.join('');
}



//返回會員系統
function back(){
//		window.location.href = "<%=request.getContextPath()%>/MemberSysServlet?action"
 		history.back()
	}
