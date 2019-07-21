var address = document.getElementById("address");
var detailedAddress = document.getElementById("detailedAddress");
var start_time = document.getElementById("start_time");
var start_time_minutes = document.getElementById("start_time_minutes");
var end_time= document.getElementById("end_time");
var end_time_minutes = document.getElementById("end_time_minutes");
var game_type = document.getElementById("game_type");
var gender = document.getElementById("gender");
var number_appliable = document.getElementById("number_appliable");
var detailInfo = document.getElementById("detailInfo");

var number;
var map;
var o_address;
var o_detailedAddress;
var o_start_time;
var o_start_time_minutes;
var o_end_time;
var o_end_time_minutes;
var o_game_type;
var o_gender;
var o_number_appliable;
var o_detailInfo;
var o_x;
var o_y;
var markers = [];
// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places();  

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

var mapContainer = document.getElementById('map'); // 지도를 표시할 


(function(){
	number = window.localStorage.getItem("number"); 
    var request = new XMLHttpRequest();
    request.open("POST", "api?number="+ number, true);
    request.onreadystatechange = dataParsing;
    request.send(null);
    function dataParsing(){
        if(request.readyState == 4 && request.status == 200){
            var json = JSON.parse(request.responseText);
            number = json.number;
            o_address = json.address;
            o_detailedAddress = json.detailedAddress;
            o_start_time = json.start_time;
            o_start_time_minutes = json.start_time_minutes;
            o_end_time = json.end_time;
            o_end_time_minutes = json.end_time_minutes;
            o_game_type = json.game_type;
            o_gender = json.gender;
            o_number_appliable = json.number_appliable;
            o_detailInfo = json.detail_Info;
            o_x = json.x;
            o_y = json.y;

            address.value = o_address;
            detailedAddress.value = o_detailedAddress;
            start_time.value = o_start_time;
            start_time_minutes.value = o_start_time_minutes;
            end_time.value = o_end_time;
            end_time_minutes.value = o_end_time_minutes;
            game_type.value = o_game_type;
            gender.value = o_gender;
            number_appliable.value = o_number_appliable;
            detailInfo.value = o_detailInfo;
            mapOnlyMarker(o_y, o_x);
        } else{
            alert("네트워크 에러 발생");
        }
    }
})();

function applyMode(){
	var request = new XMLHttpRequest();
    request.open("GET", "api?number="+number, true);
    request.onreadystatechange = checkInfo;
    request.send(null);
    
    function checkInfo(){
    	if(request.readyState == request.DONE && request.status == 200){
    		
    	}else{
    		alert("지원하기가 되지 않았습니다.!!!!")
    	}
    }
}


function mapOnlyMarker(o_y, o_x){
    // 마커를 담을 배열입니다
    mapOption = {
        center: new kakao.maps.LatLng(o_y, o_x), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };      
    // 지도를 생성합니다    
    map = new kakao.maps.Map(mapContainer, mapOption); 
    var markerPosition  = new kakao.maps.LatLng(o_y, o_x); 
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        position: markerPosition
    });
    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);
}