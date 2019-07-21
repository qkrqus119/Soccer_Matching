var lat= "";
var lng = "";
var data = "";


navigator.geolocation.getCurrentPosition(function(pos) {
    lat = pos.coords.latitude;
    lng = pos.coords.longitude;
})

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(lat, lng), // 지도의 중심좌표
        level: 8 // 지도의 확대 레벨
    };

//지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

var clusterer = new kakao.maps.MarkerClusterer({
	map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
    minLevel: 10, // 클러스터 할 최소 지도 레벨
    disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
});


var request = new XMLHttpRequest();
request.open("GET", "api/match-boards", true);
request.onreadystatechange = clustering;
request.send(null);

var tempArr = new Array();

function clustering(){
	if(request.readyState == request.DONE && request.status == 200){
		data = request.responseText;
		var json = JSON.parse(data);
		var tempObj = new Object();
		tempArr = new Array();
		for (var i= 0; i< json.length; i++){
			tempObj.lat = json[i].y;
			tempObj.lng = json[i].x;
			tempArr.push(tempObj);
		};
		var posData = tempArr;
		var markers = posData.map(function(i, position){
			return new kakao.maps.Marker({
				position: new kakao.maps.LatLng(position.lat, position.lng)
			});
		});
		
		clusterer.addMarkers(markers);
		
		// 마커 클러스터러에 클릭이벤트를 등록합니다
	    // 마커 클러스터러를 생성할 때 disableClickZoom을 true로 설정하지 않은 경우
	    // 이벤트 헨들러로 cluster 객체가 넘어오지 않을 수도 있습니다
	    kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {
	        // 현재 지도 레벨에서 1레벨 확대한 레벨
	        var level = map.getLevel()-1;
	        // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
	        map.setLevel(level, {anchor: cluster.getCenter()});
	    });    
	}else{
		alert("네트워크 오류 발생");
	}
}
