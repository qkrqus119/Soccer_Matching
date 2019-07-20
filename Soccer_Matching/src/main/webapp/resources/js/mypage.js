document.addEventListener('DOMContentLoaded', function() {


    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        plugins: ['dayGrid', 'list', 'bootstrap', 'interaction', ],
        locale: 'ko', //언어설정
        height: '700', // 전체 테이블 높이 설정
        aspectRatio: 1.46, //가로 세로 비율 가로/세로
        eventsTextColor: 'white', //이벤트 글자 색
        eventTimeFormat: { // 이벤트 날짜 포캣
            hour: 'numeric',
            meridiem: 'short'
        },
        displayEventTime: true, //이벤트의 시간 표시 여부

        events: [ //이벤트 데이터
            {
                id: 'a',
                title: '은평 롯데몰 A구장 "혼성매치"',
                start: '2019-07-23 16:00',
                end: '2019-07-23 18:00',
                color: 'red'
            }
        ],
        header: {
            left: 'prev,,next today',
            center: 'title',
            right: 'dayGridMonth, listWeek'
        },
        buttonText: {
            today: '오늘',
            dayGridMonth: '월간',
            listWeek: '리스트',
            day: ''
        },
        eventClick: function(info) {
            modalClicking(info);
        },
        noEventsMessage: "등록 또는 신청한 경기가 없습니다.",
        columnHeaderHtml: function(date) {
            switch (date.getDay()) {
                case 0:
                    return '<span style="color:red">일</span>';
                case 1:
                    return '<span>월</span>'
                case 2:
                    return '<span>화</span>'
                case 3:
                    return '<span>수</span>'
                case 4:
                    return '<span>목</span>'
                case 5:
                    return '<span>금</span>'
                case 6:
                    return '<span style="color:blue">토</span>'
            }
        }
    });

    calendar.render();
    ilkilling();
})

document.body.addEventListener('DOMSubtreeModified', function() {
    var ilremover = document.getElementsByClassName("fc-day-number");
    for (var i = 0; i < ilremover.length; i++) {
        ilremover[i].textContent = ilremover[i].textContent.replace("일", "");
    }

});

function ilkilling() {
    var ilremover = document.getElementsByClassName("fc-day-number");
    for (var i = 0; i < ilremover.length; i++) {
        ilremover[i].textContent = ilremover[i].textContent.replace("일", "");
    }
}

function modalClicking(info) {
    info.el.setAttribute("data-toggle", "modal");
    info.el.setAttribute("data-target", "#myModal");
    modalHeader(info);
}

function modalHeader(info) {
    document.getElementsByClassName("modal-title")[0].textContent = new Date(info.event.start).getFullYear() + "년 " + (new Date(info.event.start).getMonth() + 1) + '월 ' + new Date(info.event.start).getDate() + '일';
    modalBody(info);
}

function modalBody(info) {

    var container = document.getElementsByClassName("modal-body")[0];
    var contentsDiv = document.createElement("div"); // 한 경기 전체 컨테이너
    contentsDiv.setAttribute("class", "contentsDiv");
    contentsDiv.setAttribute("onclick", "loadMatch()");
    var regOrApply = document.createElement("div"); // 등록경기인지 지원 경기인지
    regOrApply.textContent = "등록한 경기";
    regOrApply.setAttribute("class", "regOrApply");
    regOrApply.style.color = "red";
    contentsDiv.appendChild(regOrApply);
    var timeDiv = document.createElement("div"); // timeDiv = 시간 Container
    timeDiv.setAttribute("class", "timeDiv");
    timeDiv.innerHTML =
        '<span>' + new Date(info.event.start).getHours() + '</span>' +
        '<span>:</span>' +
        '<span>' + getTwoDigitMinutes(new Date(info.event.start).getMinutes()) + '</span>';
    var contentDiv = document.createElement("div"); // contentDiv =컨텐츠 container
    contentDiv.setAttribute("class", "contentDiv");
    var firstHeader = document.createElement("p");
    firstHeader.setAttribute("class", "firstHeader"); // firstHeader = 컨텐츠의 제목
    firstHeader.textContent = info.event.title;
    var gender = "남성";
    var secondHeader = document.createElement("p"); // SecondHeader = 성별 정보 
    secondHeader.setAttribute("class", "secondHeader");
    secondHeader.innerHTML = gender;

    contentDiv.appendChild(firstHeader);
    contentDiv.appendChild(secondHeader);
    contentsDiv.appendChild(timeDiv);
    contentsDiv.appendChild(contentDiv);
    while (container.hasChildNodes()) {
        container.removeChild(container.firstChild);
    }
    container.appendChild(contentsDiv);
}

function getTwoDigitMinutes(minutes) {
    if (minutes < 10) {
        return '0' + minutes;
    } else {
        return minutes;
    }
}

function loadMatch(date) {
    var header = document.querySelector(".modal-title").textContent;
    var year = header.substring(0, 4);
    var month = header.substring(6, 7);
    var date = header.substring(9, 11);
    var time = document.querySelector(".timeDiv").textContent;

    var cDate = year + "-" + getTwoDigitMinutes(month) + "-" + date + " " + time;
    alert(cDate);
}