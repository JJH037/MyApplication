package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {
    ArrayList<Building> building=new ArrayList<Building>();
    ListView listview = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //1xx
        building.add(new Building("MEMS/NANO 클린룸동", R.drawable.mapimg_101, "101"
                , "대량생산을 위한 폴리머 메탈룸이며, 국내 유일의 인력양성을 위한 MEMS/NANO 실습공간과 동남권역 기업지원을 위해 운영되고 있습니다.", ""));
        building.add(new Building("제1 부속공장", R.drawable.mapimg_102, "102"
                , "3차원 측정, 용접, 절단 등을 위한 공과대학 학생들의 실습 공간입니다.", ""));
        building.add(new Building("제12 공학관", R.drawable.mapimg_103, "103"
                , "항공우주공학과 및 기계공학부 공간입니다.", ""));
        building.add(new Building("제3 공학관(융합기계관)", R.drawable.mapimg_105, "105"
                , "공과대학 기계공학부 전용관입니다.", ""));
        building.add(new Building("효원문화회관", R.drawable.mapimg_106, "106"
                , "전시 및 문화시설, 각종 편의시설, 영화관 등이 들어선 종합 문화 복지 시설입니다.", ""));

        building.add(new Building("제8 공학관(항공관)", R.drawable.mapimg_107, "107"
                , "공과대학 기계공학부, 산업공학과 등의 수업을 지원하며 특히 항공기 관련 실험분석실이 배치되어 있습니다.", ""));
        building.add(new Building("제9 공학관(기전관)", R.drawable.mapimg_108, "108"
                , "공과대학 항공우주공학, 전자전기정보통신공학, 전자공학 전공자들을 위한 학습 공간입니다.", ""));
        building.add(new Building("공과대학 공동실험관", R.drawable.mapimg_109, "109"
                , "공과대학 기계공학부, 항공우주공학과, 전자전기공학부 등의 실험 공간입니다.", ""));
        building.add(new Building("에너지분야 실험실", R.drawable.mapimg_110, "110"
                , "분무 및 미립화, 마이크로/유체생체 연구실 등이 자리하고 있습니다.", ""));
        building.add(new Building("실험폐기물처리장", R.drawable.mapimg_111, "111"
                , "각종 실험과정에서 배출되는 폐기물을 위생적으로 처리하는 시설입니다.", ""));

        //2xx
        building.add(new Building("제6 공학관(컴퓨터공학관)", R.drawable.mapimg_201, "201"
                , "컴퓨터 관련학과의 수업과 연구를 지원합니다.", "컴공 제도"));
        building.add(new Building("운죽정", R.drawable.mapimg_202, "202"
                , "카페테리아 및 기념품 판매처로 활용됩니다.", "카페"));
        building.add(new Building("넉넉한터", R.drawable.mapimg_203, "203"
                , "각종 축제 및 행사에 활용되는 소규모 운동장입니다.", "넉터"));
        building.add(new Building("넉넉한터 지하주차장", R.drawable.mapimg_204, "204"
                , "넉넉한터 지하에 위치한 주차장으로 차량 305대를 주차할 수 있습니다.", ""));
        building.add(new Building("대학본부", R.drawable.mapimg_205, "205"
                , "대학전체의 행정업무를 관리하는 부서들이 배치되어 있으며 대학의 주요정책이 수립·집행되는 곳입니다.", ""));

        building.add(new Building("제11 공학관(조선해양공학관)", R.drawable.mapimg_206, "206"
                , "조선해양학 관련 분야의 강의 및 연구가 진행되는 공간입니다.", ""));
        building.add(new Building("제10 공학관(특성화공학관)", R.drawable.mapimg_207, "207"
                , "기계, 전기, 산업공학 등 공학 전공학도들의 강의 및 연구를 지원하기 위한 설비를 갖추고 있습니다.", ""));
        building.add(new Building("기계기술연구동", R.drawable.mapimg_208, "208"
                , "기계공학 분야 연구를 통해 기계공업 발전과 고급기술인력 양성을 지원합니다.", ""));
        building.add(new Building("상남국제회관", R.drawable.mapimg_209, "209"
                , "국내외 학술교류를 목적으로 건립된 호텔형 컨벤션센터로 회의실, 연회장, 예식장으로도 활용되고 있습니다.", "북문"));
        building.add(new Building("언어교육원", R.drawable.mapimg_210, "210"
                , "각종 외국어 교육을 위한 전문기관으로서 초현대식 건물과 최첨단 장비를 갖춘 어학실습실, 강의실, 세미나실을 보유하고 있습니다.", "북문"));

        building.add(new Building("보육종합센터", R.drawable.mapimg_211, "211"
                , "어린이집, 영유아보육연구소, 보육정보센터를 포괄하는 기관으로 연구와 지역사회 봉사에 주력하고 있습니다.", "북문"));

        //3xx
        building.add(new Building("공대제2별관", R.drawable.mapimg_300, "K08"
                , "공대제2별관(RC조 연학실)", ""));
        building.add(new Building("구조실험동", R.drawable.mapimg_301, "301"
                , "공과대학 토목공학과 및 건축학부가 연구하는 각종 구조물의 정적 및 동적실험을 수행하는 곳입니다.", "토목 건축"));
        building.add(new Building("토조실험동", R.drawable.mapimg_302, "302"
                , "토질공학 및 지반공학을 위한 실험·실습 및 연구 공간입니다.", ""));
        building.add(new Building("기계관", R.drawable.mapimg_303, "303"
                , "기계공학부 전용 교수연구실, 실험실, 강의실 등으로 이용되는 공간입니다. 지하1층 지상11층 연면적 22,998m2 규모의 부산캠퍼스 내 최대 교육연구시설입니다.", ""));
        building.add(new Building("인문관", R.drawable.mapimg_306, "306"
                , "구 본관 건물로, 현재 인문대학의 중심 건물로 활용되고 있습니다. 건축가 김중업 선생의 초기 작품으로 유명합니다.", "구본관 구 본관"));

        building.add(new Building("인문대교수연구동", R.drawable.mapimg_307, "307"
                , "인문대학 교수들의 연구 활동이 이루어지는 연구실이 배치되어 있습니다.", "연구실"));
        building.add(new Building("제1 물리관", R.drawable.mapimg_308, "308"
                , "입자물리,핵물리,응집물질물리,광학,통계물리 등 물질의 근본과 우주의 기원을 이해하고자 하는 우수 물리학도를 양성하고 있는 곳입니다.", ""));
        building.add(new Building("제2 물리관", R.drawable.mapimg_309, "309"
                , "일반물리, 현대물리, 고급물리 등 물리학 전반에 걸친 강의 및 연구가 활발히 진행되는 공간입니다.", ""));
        building.add(new Building("문창회관", R.drawable.mapimg_310, "310"
                , "교직원과 학생들을 위한 식당, 우체국 등이 위치해 있습니다.", "식당 우체국"));
        building.add(new Building("공동연구기기동", R.drawable.mapimg_311, "311"
                , "고성능 설비 및 기기를 갖추고 연구 활동을 지원하고 있습니다.", ""));

        building.add(new Building("공동실험실습관", R.drawable.mapimg_312, "312"
                , "공동 활용도가 높은 고성능 기기를 갖추어 수준 높은 교수 연구와 학생 실험·실습을 지원하는 기관입니다.", ""));
        building.add(new Building("자연대 연구실험동", R.drawable.mapimg_313, "313"
                , "최첨단 연구장비로 고급 과학 인력을 양성하는 연구 공간입니다.", ""));
        building.add(new Building("정보화교육관", R.drawable.mapimg_314, "314"
                , "정보화본부 기능 중 IT교육 및 실습 업무를 담당하고 있습니다.", ""));
        building.add(new Building("자유관 A동", R.drawable.mapimg_315, "315"
                , "BTL 기숙사 신축", "기숙사"));
        building.add(new Building("자유관 B동", R.drawable.mapimg_316, "316"
                , "BTL 기숙사 신축", "기숙사"));

        building.add(new Building("직장어린이집", R.drawable.mapimg_317, "317"
                , "부산대 구성원 자녀를 위한 직장어린이집으로 생태유아교육을 실천하고 있습니다.", ""));
        building.add(new Building("자유주차장", R.drawable.mapimg_318, "318"
                , "자유주차장", ""));

        //4xx
        building.add(new Building("건설관", R.drawable.mapimg_401, "401"
                , "900석 가량의 정독실 및 열람실이 제공되어 학생들의 수학을 지원하며, 소규모 서고를 갖추고 있습니다.", "정독실 열람실"));
        building.add(new Building("정학관", R.drawable.mapimg_402, "402"
                , "옛 총장공관으로 현재 온실로 개조되어 활용되고 있습니다.", "온실"));
        building.add(new Building("10. 16 기념관", R.drawable.mapimg_403, "403"
                , "대학극장인 효원회관을 리모델링한 예술·문화공연 공간입니다.", "예술 공연 문화"));
        building.add(new Building("제2 공학관(재료관)", R.drawable.mapimg_405, "405"
                , "공과대학 행정실이 위치하고 있으며, 재료공학부와 환경공학과가 자리하고 있습니다.", "재료 환경"));
        building.add(new Building("제7 공학관(화공관)", R.drawable.mapimg_406, "406"
                , "공과대학 고분자공학과와 화학공학과의 강의 및 연구가 수행되는 공간입니다.", "고분자 화학"));

        building.add(new Building("선박예인수조연구동", R.drawable.mapimg_407, "407"
                , "세계 대학 중 최고의 최첨단 수조실험시설을 갖추고 있는 곳으로 첨단조선 공학연구센터가 운영되고 있습니다.", ""));
        building.add(new Building("제5 공학관(유기소재관)", R.drawable.mapimg_408, "408"
                , "유기소재시스템공학과가 위치하여 각종 관련 수업과 연구를 수행합니다.", "유기소재시스템"));
        building.add(new Building("교수회관", R.drawable.mapimg_409, "409"
                , "교수복지시설로 서점, 농협, 교수식당, 교수회 및 여교수회 사무실이 입주해 있습니다.", "서점 농협 교수식당"));
        building.add(new Building("선박충격ㆍ피로ㆍ도장ㆍ시험연구동", R.drawable.mapimg_410, "410"
                , "LNG선 및 쇄빙선 관련 극저온 연구를 위한 실험동입니다.", ""));
        building.add(new Building("자연과학관", R.drawable.mapimg_411, "411"
                , "자연과학대학 중심 건물로 물리·화학·생명과학분야의 전문인력을 양성합니다.", ""));

        building.add(new Building("박물관 A", R.drawable.mapimg_412, "412"
                , "1964년에 개관한 부산·경남지역의 선사문화 및 가야문화 유적의 보고로, 총 1034점의 유물을 소장하고 있습니다.", ""));
        building.add(new Building("박물관 B", R.drawable.mapimg_413, "413"
                , "1964년에 개관한 부산·경남지역의 선사문화 및 가야문화 유적의 보고로, 총 1034점의 유물을 소장하고 있습니다.", ""));
        building.add(new Building("지구관", R.drawable.mapimg_414, "414"
                , "지구관", ""));
        building.add(new Building("샛벌회관", R.drawable.mapimg_415, "415"
                , "학생 전용 식당입니다.", "학생식당"));
        building.add(new Building("생물관", R.drawable.mapimg_416, "416"
                , "생물·미생물 등 순수기초과학 분야에 대한 연구와 교육이 이루어지는 곳으로 고급 자연과학 인력의 산실입니다.", ""));

        building.add(new Building("제1 사범관", R.drawable.mapimg_417, "417"
                , "학문적 탐구에 중점을 두고 교육자적 자질 및 인격을 길러주는 사범대학 전용관입니다.", ""));
        building.add(new Building("제2 교수연구동", R.drawable.mapimg_418, "418"
                , "교수들의 활발한 연구 활동이 이루어지는 곳입니다.", ""));
        building.add(new Building("금정회관", R.drawable.mapimg_419, "419"
                , "교직원 및 학생들을 위한 구내식당입니다.", "식당"));
        building.add(new Building("새벽벌도서관", R.drawable.mapimg_420, "420"
                , "이용률이 낮은 자료를 소장하고 담당자가 책을 직접 찾아주는 폐가제 보존서고로 운영되고 있습니다.(열람 및 대출 가능) 2017년 6월 26일부터 제2도서관에서 새벽벌도서관으로 명칭을 변경하였습니다.", "제2도서관"));
        building.add(new Building("사회관", R.drawable.mapimg_421, "421"
                , "사회과학대학 학생들이 사회 제반 현상을 탐구하는 공간입니다. 원을 그리며 펼쳐진 건물 앞 잔디밭이 유명합니다.", ""));

        building.add(new Building("성학관", R.drawable.mapimg_422, "422"
                , "부산캠퍼스의 현대화 및 교육·연구환경 개선을 위해 대학 발전기금으로 건설된 첫번째 건물입니다. 총면적 1,676평, 지하 1층, 지상 7층 규모를 자랑합니다.", ""));

        //5xx
        building.add(new Building("약학연구동", R.drawable.mapimg_501, "501"
                , "약학을 연구하기 위한 제반 시설들이 구비되어 있습니다.", "약대"));
        building.add(new Building("약학관(구관)", R.drawable.mapimg_502, "502"
                , "약학대학 중심 건물로 생명의 존엄성을 중시하는 전문약사를 양성하고 있습니다.", "약대"));
        building.add(new Building("약학관(신관)", R.drawable.mapimg_503, "503"
                , "약학대학 전용관입니다.", "약대"));
        building.add(new Building("실험동물센터", R.drawable.mapimg_505, "505"
                , "약학대학 학생들의 실험 및 실습 공간입니다.", "약대"));
        building.add(new Building("효원산학협동관", R.drawable.mapimg_506, "506"
                , "중소기업창업보육센터가 위치해 있습니다.", ""));

        building.add(new Building("인덕관", R.drawable.mapimg_507, "507"
                , "초대 총장인 윤인구 박사를 기리기 위해 건립한 곳으로 최첨단 원격화상강의실을 갖추고 있습니다.", ""));
        building.add(new Building("산학협동관", R.drawable.mapimg_508, "508"
                , "정부, 지방자치단체, 산업체 등과의 상호 협력을 통해 산학협력을 촉진시키는 산학협동의 심장부로서 산학협력단이 자리잡은 곳입니다.", ""));
        building.add(new Building("박물관 별관", R.drawable.mapimg_509, "509"
                , "선조들의 지혜와 숨결을 엿볼 수 있는 박물관의 부속건물로 발굴된 유물을 보관하는 유물수장고로 사용됩니다.", ""));
        building.add(new Building("중앙도서관", R.drawable.mapimg_510, "510"
                , "2011년 증축 개관했으며, 4개 주제자료관(인문사회/어문학/과학기술/예체능)과 iCOMMONS, 미디어갤러리 등을 운영하고 있습니다. 2017년 6월 26일부터 제1도서관에서 중앙도서관으로 명칭을 변경하였습니다.", "중도 제1도서관"));
        building.add(new Building("간이체육관", R.drawable.mapimg_511, "511"
                , "체육교육과 학생들의 실내체육활동 공간으로 활용됩니다.", ""));

        building.add(new Building("테니스장", R.drawable.mapimg_512, "512"
                , "교직원과 학생들을 위한 테니스 연습 및 시합 공간입니다.", ""));
        building.add(new Building("철골주차장", R.drawable.mapimg_513, "513"
                , "상과대학, 법학전문대학원, 사회과학대학 등 주변에 위치한 건물을 감안한 주차편의 제공을 위한 주차장입니다.", ""));
        building.add(new Building("경영관", R.drawable.mapimg_514, "514"
                , "유망한 경제·경영인을 양성하는 상과대학 건물입니다.", "상대"));
        building.add(new Building("중앙도서관 및 정보화본부", R.drawable.mapimg_515, "515"
                , "2011년 신축 이전했으며, 빠르고 안정적인 전산망 인프라와 초고속 컴퓨터로 학사·행정지원시스템을 운영하고 있습니다.", ""));
        building.add(new Building("경제통상관", R.drawable.mapimg_516, "516"
                , "경제통상대학 강의실, 교수연구실 등이 자리한 교육연구시설입니다.", ""));

        //6xx
        building.add(new Building("예술관", R.drawable.mapimg_601, "601"
                , "예술대학의 중심 건물로 음악·국악·무용 등 예술 분야 전문인력을 양성하는 곳입니다.", "예대"));
        building.add(new Building("생활환경관", R.drawable.mapimg_602, "602"
                , "생활환경대학의 중심 건물로 의류학·식품영양학·주택 및 실내디자인 분야의 전문인을 양성합니다.", "의류 식품영양"));
        building.add(new Building("생활환경대실험실습동", R.drawable.mapimg_603, "603"
                , "생활환경대학의 부속 건물로 실험 및 실습을 위한 시설을 보유하고 있습니다.", ""));
        building.add(new Building("학군단", R.drawable.mapimg_605, "605"
                , "학군사관후보생(ROTC)의 훈련 및 관리가 이루어지는 곳입니다.", "ROTC 학군사관후보생"));
        building.add(new Building("화학관", R.drawable.mapimg_606, "606"
                , "화학과 및 화학교육과 학생들이 실험과 강의를 통해 전공 관련 지식을 습득하는 공간입니다.", "화학교육"));

        building.add(new Building("공동연구소동", R.drawable.mapimg_607, "607"
                , "각종 연구소가 있는 첨단연구동입니다.", ""));
        building.add(new Building("제2 법학관", R.drawable.mapimg_608, "608"
                , "우수 법조인력 양성을 위한 법학전문도서관, 모의법정, 법학연구소, 법률상담실습실, 판례정보검색실 등이 위치하고 있습니다.", "법대"));
        building.add(new Building("법학관", R.drawable.mapimg_609, "609"
                , "각종 법 관련 지식과 소양을 교육하여 법률전문가를 양성하는 법학전문대학원 건물입니다.", "법대"));

        //7xx

        building.add(new Building("제2 사범관", R.drawable.mapimg_701, "701"
                , "사범대학 인문계열 학과 전용관입니다.", ""));
        building.add(new Building("조소실", R.drawable.mapimg_702, "702"
                , "예술대학 미술학과 학생들이 조소작품을 구상하고 제작하는 공간입니다.", "예대 예술 미술 미대"));
        building.add(new Building("미술관", R.drawable.mapimg_703, "703"
                , "예술대학 미술학과 전용관입니다.", "예대 예술 미술 미대"));
        building.add(new Building("조형관", R.drawable.mapimg_704, "704"
                , "예술대학 교육연구시설입니다.", "예대 예술 미술 미대"));
        building.add(new Building("경암체육관 교수연구동", R.drawable.mapimg_705, "705"
                , "체육교육과 및 스포츠과학부 교수연구동입니다.", "체육교육 스포츠과학 체대"));

        building.add(new Building("경암체육관", R.drawable.mapimg_706, "706"
                , "최첨단 복합스포츠시설로, 1,600석 규모의 실내체육관과 스포츠센터 등이 있습니다.", ""));
        building.add(new Building("음악관", R.drawable.mapimg_707, "707"
                , "예술대학 교육ㆍ연구 지원 시설로, 콘서트홀(256석)과 야외공연장 등을 갖추고 있습니다.", "예대 예술 음대"));
        building.add(new Building("학생회관", R.drawable.mapimg_708, "708"
                , "학생들을 위한 각종 편의시설 및 식당을 운영 중이며 주요 동아리방이 자리 잡고 있는 공간입니다.", ""));
        building.add(new Building("과학기술연구동", R.drawable.mapimg_709, "709"
                , "차세대물류IT기술연구사업단의 물류IT 기술개발을 위한 연구개발 핵심기반시설 및 항만물류 관련 산업체 연구개발 공동 연구 시설로 활용하고 있습니다.\n", ""));
        building.add(new Building("효원재", R.drawable.mapimg_711, "711"
                , "재학생 및 졸업생 고시준비생들을 위해 숙식 및 정보를 지원합니다.", ""));

        building.add(new Building("웅비관 A동", R.drawable.mapimg_712, "712"
                , "1,058명을 수용할 수 있는 첨단 기숙사입니다.", "기숙사"));
        building.add(new Building("웅비관 B동", R.drawable.mapimg_713, "713"
                , "1,058명을 수용할 수 있는 첨단 기숙사입니다.", "기숙사"));
        building.add(new Building("진리관 관리동", R.drawable.mapimg_714, "714"
                , "남학생 기숙사인 진리관의 관리업무가 이루어지는 곳입니다.", "기숙사"));
        building.add(new Building("진리관 가동", R.drawable.mapimg_715, "715"
                , "남학생 전용 기숙사입니다.", "기숙사"));
        building.add(new Building("진리관 나동", R.drawable.mapimg_716, "716"
                , "남학생 전용 기숙사입니다.", "기숙사"));

        building.add(new Building("진리관 다동", R.drawable.mapimg_717, "717"
                , "남학생 전용 기숙사입니다.", "기숙사"));



        MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, building);

        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(getApplicationContext(), Detail.class); // 다음넘어갈 화면

                // intent 객체에 데이터를 실어서 보내기
                // 리스트뷰 클릭시 인텐트 (Intent) 생성하고 position 값을 이용하여 인텐트로 넘길값들을 넘긴다
                intent.putExtra("Name", building.get(position).name);
                intent.putExtra("Img", building.get(position).img);
                intent.putExtra("Number", building.get(position).num);
                intent.putExtra("Info", building.get(position).info);
                intent.putExtra("Tag", building.get(position).tag);

                startActivity(intent);
            }
        });

        EditText editTextFilter = (EditText)findViewById(R.id.editTextFilter) ;
        final ListView finalListview = listview;
        editTextFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                String filterText = edit.toString() ;
             /*
                if (filterText.length() > 0) {
                    listview.setFilterText(filterText) ;
                } else {
                    listview.clearTextFilter() ;
                }
              */
                ((MyAdapter) finalListview.getAdapter()).getFilter().filter(filterText) ;
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        }) ;
    }
}

class Building {
    String name = "";
    int img;
    String num = "";
    String info = "";
    String tag = "";

    public Building(String name, int img, String num, String info, String tag) {
        super();
        this.name = name;
        this.img = img;
        this.num = num;
        this.info = info;
        this.tag = tag;
    }

    public String getName() {
        String name = this.name;
        return name;
    }

    public String getNum() {
        String num = this.num;
        return num;
    }

    public String getOther() {
        String tag = this.tag;
        return tag;
    }

}