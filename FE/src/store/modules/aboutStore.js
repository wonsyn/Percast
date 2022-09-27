const aboutStore = {
  namespaced: true,
  state: {
    data: [
      {
        season: "봄",
        entity: [
          {
            name: "홍역",
            english: "Measles",
            explain: [
              "사계절 두루 발생하지만 유행하는 시기는 3월~6월이고 5월에 많이 발생하는 급성 열성 발진성 질환입니다.",
              "특히 1세~5세 사이의 소아에게서 발생률이 가장 높음",
            ],
            elements: [
              {
                title: "원인균",
                text: ["Measles virus"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "비말 등의 공기매개 감염 또는 환자의 코, 인두 분비물과 직접 접촉으로 전파됨",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["전염력이 매우 높아 접촉자의 95%가 발병함"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: ["8일~12일"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요 증상",
                text: [],
                list: [
                  {
                    title: "전구기",
                    text: [
                      "기침, 콧물, 결막염, 발열(38℃ 이상) 등이 발생하며 전염력이 가장 강한 시기로 3~5일간 지속됨",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "발진기",
                    text: [
                      "특징적으로 머리에서 시작하여 얼굴, 목, 팔, 몸통 순으로 발진이 나타나며 이때 40℃ 이상의 고열이 동반",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "회복기",
                    text: [
                      "피부발진이 작은 겨 껍질모양으로 벗겨지며 이 시기에 폐렴, 중이염, 기관지염 등의 합병증이 유발될 수 있음",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "예방접종",
                text: ["MMR(홍역) 기초 1회, 생후 12~15개월 추가 1회 만 4~6세"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["정해진 시기에 예방접종 실시"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["환자는 발진 후 5일까지 격리"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["외출 후 곧바로 손발을 씻고 양치질"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
          {
            name: "유행성이하선염",
            english: "Mumps",
            explain: [
              "최근에 유행하는 호흡기 질환으로 봄철에 유행하며 특히 5세~15세 소아에게서 빈발하는 이하선 부종을 특징으로 하는 급성 열성 질환",
            ],
            elements: [
              {
                title: "원인균",
                text: ["Mumps virus"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["비말 등의 공기매개 감염"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["환자의 타액과 직접 접촉으로 전파됨"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: ["14일~21일"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요 증상",
                text: [
                  "잠복기 후 1~2일간의 발열, 두통, 근육통, 구토 등의 전구 증상이 있다가",
                  "침샘(주로 이하선)을 침범하여 종창, 동통(통증), 부종을 유발합니다.",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "예방접종",
                text: [
                  "MMR을 생후 12~15개월에 1회 기초접종 만 4~5세에 1회 추가접종",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["정해진 시기에 예방접종 실시"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["환자는 발병 후 9~10일동안 격리"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "환자의 타액이나 호흡기 분비물에 오염된 물품을 소독",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [
                  {
                    title: "",
                    text: ["꼭 예방접종을 맞도록 합시다."],
                    list: [],
                    emphasize: [],
                  },
                ],
              },
            ],
          },
          {
            name: "풍진",
            english: "Rubella",
            explain: [
              "학생들을 중심으로 2월~3월에서 초여름인 6월까지 유행하며 임신초기의 여성이 걸렸을 경우 풍진 증후군이라 부르며 뱃속 아이에게 심장기형이나 백내장, 청력장애 등을 유발하여",
              "각별하게 주의를 요하는 급성 열성 질환",
            ],
            elements: [
              {
                title: "원인균",
                text: ["Rubella virus"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "기침, 재채기 등으로 체내에 침입(공기감염, 비말감염)하여 감염",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "감염된 산모의 태반을 통해 태아에 수직 감염되기도 함",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: ["14일 ~ 21일 (평균 16일 ~ 18일)"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [
                  "두통, 전신쇠약 등을 일으키며 홍역보다 증세는 가볍고 비교적 짧은 기간 내 소실합니다.",
                  "비교적 경한 임상경과를 취하며(30~50%는 증상이 없음)",
                  "얼굴에서 시작하여 몸통으로 퍼지는 발진과 발열이 나타납니다.",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "예방접종",
                text: [
                  "MMR을 생후 12~15개월에 1회 기초 접종. 만 4~5세 때 1회 추가접종",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["정해진 시기에 예방접종 실시"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["환자는 발진 후 5까지 격리"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "임신 4개월 미만의 임산부는 환자와의 접촉을 절대적으로 피함",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [
                  {
                    title: "",
                    text: ["감염 가능기간 발진이 나타난 후 5일까지"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["꼭 예방접종을 맞도록 합시다."],
                    list: [],
                    emphasize: [],
                  },
                ],
              },
            ],
          },
          {
            name: "백일해",
            english: "Pertussis",
            explain: [
              "격렬한 기침을 주증상으로 하는 급성 호흡기 질환으로 4계절에 발생하나 봄, 여름에 걸쳐 호발하며",
              "주로 영유아기에 발생하는 치명률(15%)이 높은 질환",
            ],
            elements: [
              {
                title: "원인균",
                text: ["Bordetella pertussis"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [
                  "직접적인 접촉에 의해서 전파 되거나 기침을 할 때 튀어나온 작은 침방울에 의해 호흡기로 전파",
                ],
                list: [],
                emphasize: [
                  {
                    title: "",
                    text: ["감염력이 매우 높아 2차 발병율이 80%이상"],
                    list: [],
                    emphasize: [],
                  },
                ],
              },
              {
                title: "잠복기",
                text: ["7일~20일"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "전구기(카타르기 1~2주)",
                    text: [
                      "콧물, 눈물, 경한 기침, 미열 등의 상기도염 증세*가장 감염력이 강한 시기",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "경해기(2~4주)",
                    text: ["발작적인 기침 후 구토, 끈근한 점액성 가래"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "회복기(1~2주)",
                    text: ["기침의 정도와 횟수 및 구토 감소"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "예방접종",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "DTap를 생후 2개월부터 2개월 간격으로 3회 기초 접종",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["생후 18개월과 만 4~6세에 추가 접종"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["예방접종 스케줄에 따라 예방접종을 실시"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "백일해 환자는 격리하고 환자의 비인두 분비물, 분비물에 오염된 물품은 소독",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "예방접종이 안된 영유아는 사람들이 모이는 장소를 피함",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
          {
            name: "파상풍",
            english: "Tetanus",
            explain: [
              "상처 부위에서 혐기적으로 발육하는 파상풍균이 생산하는 독소인 신경독에 의한 급성 중독성 질환으로",
              "약물남용자와 미접종 산모로부터 태어난 신생아 등에서 많이 발생하는 근육의 긴장성 연축을 일으키는 질환",
            ],
            elements: [
              {
                title: "원인균",
                text: ["Clostridium tetani"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [
                  "흙, 먼지, 동물의 대변 등에 포함된 파상풍의 포자가 피부의 상처를 통해 침투하여 전파됨",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: ["1일 ~ 수개월 (평균 3일 ~ 21일)"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "전신파상풍(가장 흔한 형태)",
                    text: [
                      "입주위 근육의 수축으로 인한 개구불능이 가장 먼저 나타나며 경직에 따른 통증을 동반,",
                      "복부강직 및 호흡근육 경직에 의한 호흡곤란",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "국소파상풍",
                    text: ["국소부위의 긴장 유발"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "뇌파상풍",
                    text: [
                      "중추신경이 지배하는 근육(안면신경, 외안근등)의 마비",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "신생아파상풍",
                    text: [
                      "비위생적인 탯줄관리로 인해 발생하며 초기에는 무력감만 보이나 후기에는 경직",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "예방접종",
                text: [
                  "DTap를 생후 2개월부터 2개월 간격으로 3회 기초접종 15~18개월과 만 4~6세, 만 11세~12세에 Tb 추가 접종",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["정해진 시기에 예방접종을 실시"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "상처가 났을 때에는 상처부위를 소독하고 괴사 조직을 제거하는 등의 적절한 처리를 함",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
          {
            name: "성홍열",
            english: "Scarlet fever",
            explain: [
              "늦은 겨울과 초봄에 호발하는 질환으로 주로 6세~12세 아동에 발생하는 연쇄구균의 발열성 외독소에 의한 급성 열성 질환",
            ],
            elements: [
              {
                title: "원인균",
                text: ["Group A β- hemolytic streptococci"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "주로 비말감염 또는 환자와 보균자의 분비물과 직접 접촉에 의해 전파",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "드물게 손이나 물건을 통한 간접 접축에 의해서도 전파",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "균에 오염된 우유, 아이스크림이나 기타 음식물을 통해서도 전파가능",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "긴밀한 접촉이 흔한 학교, 어린이 보호시설, 군대 등에서 유행발생이 가능함",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: ["1일 ~ 3일"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["발열(39~40℃), 인두통등이 생긴 후 발진이 발생"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["심한 인후 충혈, 연구개 및 목젖의 출혈반, 딸기혀"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["편도선이나 인두 후부에 점액 농성의 삼출액"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "환자는 치료를 시작하고 24시간동안은 감염성이 있으므로 격리",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["매액 및 분비물로 오염된 물품 소독"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
          {
            name: "수두",
            english: "Chickenpox",
            explain: [
              "수두-대상포진 바이러스에 의한 급성발진성 질환으로",
              "매년 약 18만명의 수두 환자가 발생하며, 대부분 3~6세 소아에서 발생하고 감염력이 강한 질환 (2005. 7.1 제2군 감염병에 추가됨)",
            ],
            elements: [
              {
                title: "원인균",
                text: ["Varicella-zoster virus"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "수두나 대상포진 수포액의 직접접촉이나 공기를 통한 전파",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["수두 감염자의 타액에 의한 감염"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: ["10일 ~ 21일 (평균 14일 ~ 16일)"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "전구증상",
                    text: ["발열, 권태감, 식욕 부진 등"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["발진 → 3~4일간의 수포(물집)기 → 가피(딱지)"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "예방접종",
                text: [
                  "피하주사용 생백신을 1~12세까지 감수성이 있는 사람에게 접종",
                  "(성인이 4~8주 간격으로 2회 투여하면 약 70%에서 효과)",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [
                  "처음 발행한 후 5일간 혹은 수포가 마를 때까지 환자를 격리",
                ],
                list: [],
                emphasize: [],
              },
            ],
          },
        ],
      },
      {
        season: "여름",
        entity: [
          {
            name: "폴리오",
            english: "Poliomyelitis",
            explain: [
              "급성회백수염. 기온이 20℃이상이 되는 6월부터 9월 사이에 환자가 많이 발생하는",
              "소아이환율이 높고 마비를 일으키는 폴리오 바이러스에 의한 전염성 질환",
            ],
            elements: [
              {
                title: "원인균",
                text: ["Polio virus"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: ["경구감염으로 전파"],
                list: [],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: [],
                list: [
                  {
                    title: "불현성 간염",
                    text: ["3~6일"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "마비성 폴리오",
                    text: ["7~21일(4일정도로 단기간 일 수도 있음)"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "경증으로 미열만 있거나 권태감, 두통, 구토, 설사 등",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "바이러스가 신경조직에 침입하면 근육통, 경부 배부경직",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "일부에서는 이완성 마비가 3~4일 지속됨(감염자중 90%이상이 무증상이고 경증으로 지나감)",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "예방접종",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["생후 12~24개월에 1~2주 간격으로 2회 기초접종"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["12개월 후 3차 기초접종"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["만 6세와 만 12세에 각 1회 추가접종"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["정해진 시기에 예방접종 실시"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["환자의 장내배설물 격리"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["환자의 목 분비물, 대변과 이에 오염된 물품 소독"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
          {
            name: "일본뇌염",
            english: "",
            explain: [
              "일본뇌염 바이러스를 가진 모기에 의해 발병되는 전염병으로 우리나라의 일본뇌염",
              "유행시기는 대체로 7월 중순부터 10월 초순까지이며",
              "그 중에서 8월 하순부터 9월 중순까지 1개월 사이에 전체의 약 80%가 집중적으로 발생",
            ],
            elements: [
              {
                title: "원인균",
                text: [],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [
                  "감염된 돼지를 흡혈한 작은 빨간집 모기가 사람을 흡혈하여 전염",
                ],
                list: [],
                emphasize: [
                  {
                    title: "",
                    text: [
                      "보통모기는 꼬리를 쳐들고 앉는데 비하여 뇌염 모기는 수평으로 앉으며 밤 8시~10시에 가장 활발하게 활동함",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
              },
              {
                title: "잠복기",
                text: ["7일~14일"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "감염자의 95%이상이 무증상이며 일부에서 열을 동반하는 가벼운 뇌염으로 진행",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "뇌염의 경우 성격변화와 신경증상이 나타난 후 오한과 두통이 심해지면서 고열과 함께 경련 및 의식 소실과",
                      "혼수상태로 (약30%의 사망률)진행",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "뇌염의 경우 회복되어서도 1/3에서 침범부위에 따른",
                      "다양한 신경계 합병증(기억력 상실, 판단력 저하, 운동장애 등)이 나타남",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "예방접종",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["생후 12~24개월에 1~2주 간격으로 2회 기초접종"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["12개월 후 3차 기초접종"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["만 6세와 만 12세에 각 1회 추가접종"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["정해진 시기에 예방접종 실시"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["모기의 번식지와 서식지의 환경개선"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["모기에 물리지 않도록 주의"],
                    list: [],
                    emphasize: [
                      {
                        title: "",
                        text: [
                          "12세 이하 아동, 50세 이상의 고령자는 특히 주의",
                        ],
                        list: [],
                        emphasize: [],
                      },
                    ],
                  },
                ],
                emphasize: [],
              },
            ],
          },
          {
            name: "수족구병",
            english: "",
            explain: [
              "입 안의 물집과 궤양, 손과 발의 수포성 발진이 특징인",
              "생후 6개월에서 4~5세 아동에게 많이 발생하는 장내바이러스에 의해 발병하는 질환",
            ],
            elements: [
              {
                title: "원인균",
                text: ["Coxsakie virus A16, Enterovirus 71"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [
                  "환자의 분변, 또는 호흡기 분비물(침, 가래, 콧물)을 통해서 전파",
                ],
                list: [],
                emphasize: [
                  {
                    title: "",
                    text: ["발병 1주일이 전염력이 강함"],
                    list: [],
                    emphasize: [],
                  },
                ],
              },
              {
                title: "잠복기",
                text: ["3일~5일"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["발열, 인후통, 식욕부진 등으로 시작"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "발열 후 1~2일째에 수포성 구진이 손바닥, 손가락, 발바닥에 생김",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["구내 병변은 볼의 점막, 잇몸이나 혀에 나타남"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "때로는 둔부에도 나타나지만, 수포 대신 발진만 나타나는 경우도 많음",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["발병 초기 수일간 환자격리"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["환자의 배설물이 묻은 옷 등은 철저히 소독"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["개인위생(손씻기 등) 철저"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
          {
            name: "비브리오 패혈증",
            english: "Vibrio vulnificus sepsis",
            explain: [
              "국내에서는 간질환을 갖고 있는 고위험군으로부터 매년 20~40환례가 발생하고 있으며,",
              "치명률이 50% 이상인 여름철 서남 해안지역의 수온이 18~20℃이상이고 염도가 25‰정도 일 때",
              "주로 발생하는 감염성 질환",
            ],
            elements: [
              {
                title: "원인균",
                text: ["Vibrio vulnificus(바다에 살고 있는 호염성 세균)"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "만성 간질환 등 저항력이 약한 허약자들이 어패류를 생식(패혈증)",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "해안지역에서 낚시 또는 어패류 손질 시 균에 오염된 해수 및 갯벌 등에서 피부상처를 통해서 감염(창상감염형)",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: [],
                list: [
                  {
                    title: "패혈증",
                    text: ["16~24시간"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "창상감염형",
                    text: ["12시간"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "패혈증",
                    text: [
                      "발열, 오한, 구토, 전신쇠약감, 설사, 하지부종, 반상출혈, 수포, 궤양, 괴사",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "창상감염형",
                    text: ["창상부위 부종, 홍반, 수포성 괴사 등"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["상처가 있는 사람은 바다에 들어가는 것을 삼가"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "여름철 어패류는 가급적으로 -5℃이하로 저온저장, 또는 60℃이상으로 가열처리 하거나 수돗물에 씻은 후 섭취",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "고위험자는 하절기 어패류 생식을 삼가",
                      "고위험자: 간질환자, 알코올중독자, 만성질환자, 위장관질환자, 재생불량성 빈혈, 부신피질호르몬제나 항암제를 복용 중인 자,",
                      "악성종양, 백혈병 환자, 면역결핍환자(AIDS, 백혈구감소증)",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
          {
            name: "레지오넬라증",
            english: "Legionellosis",
            explain: [
              "여름철 대형건물(병원, 호텔, 빌딩, 공장 등)에서 주로 발생하며",
              "치료를 받지 않으면 치명율이 15~20%로 높은 급성 호흡기 질환",
            ],
            elements: [
              {
                title: "원인균",
                text: [
                  "Legionella pneumopfila(수돗물이나 증류수 안에서 수 개월간 생존)",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [
                  "대형건물의 냉각탑, 에어컨, 샤워기, 중증호흡치료기기, 분수, 분무기 등 오염된 물에 존재하는 균이 비말로",
                  "인체에 흡입되어 전파. 퐌자의 접촉으로 직접 전파는 되지 않음",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: [],
                list: [
                  {
                    title: "레지오넬라 폐렴",
                    text: ["2일~11일"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "폰티악열(독감형)",
                    text: ["5시간~65시간"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "레지오넬라 폐렴",
                    text: [
                      "식욕부진, 근육통, 두통, 오한, 발열, 기침, 설사, 오심, 복통, 폐렴",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "폰티악열(독감형)",
                    text: ["폐렴형과 유사한 증상(비교적 경미)"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["대형 쟁각탑 및 저수 탱크의 청소(연2~4회)외 소독"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["에어컨의 필터, 물받이 등 청소(주1회 이상) 및 소독"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["가습기의 내부 청결 유지 및 신선한 물 사용"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
          {
            name: "말라리아",
            english: "",
            explain: [
              "학질, 세계보건기구(WTO)가 선정한 6대 열대병 중에서도 가장 중요한 질환으로 말라리아 원충이 적혈구 도는 간세포 안에 기생하면서 적펼구를 파괴,",
              "주기적인 열발작을 일으키는 급성열성 전신감염증",
            ],
            elements: [
              {
                title: "원인균",
                text: [
                  "삼일열원충(Plasmodium vivax): 우리나라의 토착 말라리아",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [
                  "말라리아 원충에 감염된 모기가 사람을 흡혈하여 전염드물게 수혈, 주사기 공동사용으로도 전파가능",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: ["우리나라의 삼일열 말라리아: 9개월~13개월"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "권태감과 서서히 상승하는 발열이 초기에 수 일간 지속",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["오한, 발열, 발한 후 해열이 반복적으로 나타남"],
                    list: [
                      {
                        title: "",
                        text: [
                          "오한기(춥고 떨리는 시기): 춥고 떨린 후 체온이 상승",
                        ],
                        list: [],
                        emphasize: [],
                      },
                      {
                        title: "",
                        text: [
                          "고열기: 체온이 39~41℃까지 상승하며 피부가 건조함(~90분)",
                        ],
                        list: [],
                        emphasize: [],
                      },
                      {
                        title: "",
                        text: [
                          "하열기(발한기): 심하게 땀을 흘린 후 체온이 정상으로 떨어짐(4~6시간)",
                        ],
                        list: [],
                        emphasize: [],
                      },
                    ],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["두통이나 구역, 설사 등을 동반할 수 있음"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [
                  "매개모기가 활발하게 흡혈 활동을 하는 5~9월까지 야간(밤10시부터 새벽4시)에",
                  "야외(낚시터, 야외캠핑 등)활동을 자제",
                ],
                list: [
                  {
                    title: "",
                    text: ["야간 외출 시, 긴팔 및 긴 바지를 착용할 것"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["의복에 모기 기피제 살포"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["환자의 혈액격리(헌혈금지)"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "말라리아 검사는 보건소에서 무료로 실시하며 검사결과 양성자는 무료로 치료를 받을 수 있음",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
          {
            name: "유행성결막염",
            english: "",
            explain: ["아데노 바이러스에 의해 결막에 생긴 염증성 질환 =EKC"],
            elements: [
              {
                title: "원인균",
                text: ["adenovirus 제8형과 제 19형"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [
                  "환자와의 직접적인 접촉, 환자가 사용한 물건, 세면도구, 수영장, 목욕탕 등을 통해 전파",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: ["5일~12일"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["충혈, 동통, 눈물, 눈꼽, 눈부심 등"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["아동의 경우 두통, 오한, 인두통, 설사 등 동반"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
          {
            name: "급성출혈성결막염",
            english: "",
            explain: ["아폴로눈병. 눈에 심한 통증을 수반하는 출혈성 결막염"],
            elements: [
              {
                title: "원인균",
                text: [
                  "엔테로바이러스 70, 아데노바이러스 11, 콕사키바이러스 A24 등",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "감염된 눈의 분비물에 의한 직접 또는 간접 접촉에 의해 전파",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["분변접촉에 의한 전파도 가능"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: ["8시간~48시간"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["안통, 이물감, 많은 눈물, 눈꼽, 눈부심"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["결막충혈, 부종, 결막하출혈, 결막여포, 각막염 등"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
        ],
      },
      {
        season: "가을",
        entity: [
          {
            name: "유행성출혈열",
            english: "",
            explain: [
              "신증후군 출혈열이라고도 함. 주로 야외 생활자(군인, 등산, 낚시를 즐기는 사람)에게 급성으로 발열, 요통과 출혈, 신부전을 초래하며,",
              "사람과 동물 모두에게 감염되는 바이러스성 질환",
            ],
            elements: [
              {
                title: "원인균",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["Hantaan virus, Seoul virus (도시형)"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["Puumula virus (스칸디나비아형)"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "들쥐 배설물(똥, 오줌)이 마르면서 여기에 섞여 있는 바이러스가 공중을 떠돌아다니다가 호흡기를 통해 감염",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["도시의 시궁쥐, 실험실의 쥐도 바이러스 전파가능"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: ["14일~21일"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "고열 후 뒤를 이어 단백노나 전신성의 출혈 경향 등이 발생",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "발열기(3~5일) →저혈압기(수시간~3일)→핍뇨기(3~5일)→이뇨기(7일~14일)→회복기(1~2개월)",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "늦가을(10~11월)과 늦봄(5~6월)의 건조기에 잔디 위에 눕기 금지",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "야외활동 후 귀가 시 옷에 묻은 먼지를 털고 샤워 청결에 주의",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "감염 위험성이 높은 사람(군인, 농부 등)은 예방접종",
                      "(예방접종: 1개월 간격으로 2회 접종 후 12개월 뒤에 3차 접종)",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "사람에서 사람으로 전염은 되지 않으므로 격리는 필요치 않음",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
          {
            name: "렙토스피라증",
            english: "Leptospirosis",
            explain: [
              "가을철 추수기에 농촌지역에서 주로 들쥐에 의해 사라에게 매개되는 급성 발열성 질환",
            ],
            elements: [
              {
                title: "원인균",
                text: ["Leptospirosis(렙토스피라균)"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [
                  "쥐, 족제비, 여우, 개 등 감염된 동물의 소변에 오염된 젖은 풀, 흙, 물 등과 접축 할 때 점막이나 상처 난 피부를 통해 감염",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: ["7~12일"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "발열과 두통, 오한, 근육통(특히 종아리와 허벅지), 결막충혈이 생기며 때로는 황달, 신부전증, 빈혈, 피부출혈이 발생",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "치료시기를 놓치면 사망에 이를 수 있으며 초기 증상이 감기몸살과 유사해 대수롭지 않게 여기다 치료 시기를 놓치기 쉬우니 주의가 필요",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "오염된 개천이나 강물에 들어가거나 오염된 곳에서 수영금지",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "야외에서 작업 시 직접 접촉하지 않도록 장화, 장갑 등을 착용",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "사람에서 사람으로 감염은 되지 않아 격리는 필요치 않음",
                    ],
                    list: [],
                    emphasize: [
                      {
                        title: "",
                        text: [
                          "농촌 추수기 전후인 7~11월에 20~70대 농업종사자에게 많이 발생",
                        ],
                        list: [],
                        emphasize: [],
                      },
                    ],
                  },
                ],
                emphasize: [],
              },
            ],
          },
          {
            name: "쯔쯔가무시증",
            english: "Scrub typhus",
            explain: [
              "주로 9~11월에 주로 발생하는 쯔쯔가무시균에 감염된 털진드기 유충에 물려 감염되는 급성 열성 감염병",
            ],
            elements: [
              {
                title: "원인균",
                text: ["Orientia tsutsugamushi"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [
                  "관목 숲이나 들쥐에 기생하는 진드기의 유충이 사람을 물어 감염",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: ["10~12일"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "피부발진, 그 외 고열, 오한, 두통, 결막충혈, 림프절 종대 등이 나타남",
                    ],
                    list: [],
                    emphasize: [
                      {
                        title: "",
                        text: [
                          "일부 환자는 진드기에 물린 상처가 없는 경우도 있음",
                        ],
                        list: [],
                        emphasize: [],
                      },
                    ],
                  },
                  {
                    title: "합병증",
                    text: ["뇌수막염, 난청, 이명"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["풀밭에서 옷을 벗어 놓거나 눕지 말것"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "등산, 캠핑등 야외 활동 시 기피제를 뿌리고 긴 소매 긴 양말을 착용",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "작업 및 야외활동 후 샤워나 목욕으로 진드기를 제거하고 작업복은 바로 세탁",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["풀 숲에서 용변을 보지 말 것"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "사람에서 사람으로 전염은 되지 않아 격리는 필요치 않음",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
        ],
      },
      {
        season: "겨울",
        entity: [
          {
            name: "인플루엔자",
            english: "Influenza",
            explain: [
              "독감.인플루엔자 바이러스에 의한 전염성이 강한 급성 호흡기 질환으로",
              "항원변이를 일으켜 면역력이 없는 인간집단에 대규모 유행을 일으킬 수 있어",
              "국제적인 감시를 통한 대비가 필요한 공중 보건학적으로 중요한 질병",
            ],
            elements: [
              {
                title: "원인균",
                text: ["influenza virus"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: ["환자의 호흡기 비말 등을 통한 공기매개 감염"],
                list: [],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: ["1일~4일"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "갑작스런 고열, 두통, 근육통, 전신 쇠약감과 같은 전반적인 신체 증상을 동반",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["목이 아프고 기침이 나는 등의 호흡기 증상"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["폐렴이 합병증으로 유발 될 수 있음"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "예방접종",
                text: ["매년 10월~12월에 실시(70~90% 예방효과)"],
                list: [],
                emphasize: [],
              },
              {
                title: "우선접종권장대상",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "만성질환으로 사회복지시설 등 집단시설에서 치료, 요양, 수용중인 사람",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "병원에 다닐 정도의 다음 만성질환을 앓고 있는 사람",
                      "대사질환(당뇨병)자, 신장질환자, 만성간질환자, 악성종양자면역저하 환자, 아스피린 복용 중인 6개월~18세 소아, 혈색소병증 환자",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "폐 질환자, 심장질환자, 65세 이상의 노인, 임신부, 50~64세 인구, 생후 6~23개월의 영아 및 소아,",
                      "의료인과 환자의 가족, 사스 및 조류인플루엔자 대응기관 종사자, 닭과 오리농장 및 관련업계 종사자",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
          {
            name: "수막구균성 수막염",
            english: "Meningococcal meningitis",
            explain: ["수막염균 감염에 의한 치명률이 높은 급성 중추신경계질환"],
            elements: [
              {
                title: "원인균",
                text: ["Neisseria meningitidis"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [
                  "감염자의 호흡기 분비물에 의한 비말 감염 도는 직접 감염",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: ["2일~10일"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "무증상부터 전격형까지 매우 다양한 증상",
                      "초기: 인두염, 발열, 근육통, 전신쇠약",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "패혈증 시 저혈압, 범발성 혈관내 응고증, 산증, 부신출혈, 신부전, 심부전 등 패혈성 쇼크로 급속히 진행 될 수 있음",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "뇌막염의 증상(두통, 구토, 고열, 의식저하) 등을 나타냄",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["환자의 코, 목 분비물과 이에 오염된 물품 소독"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["환자는 격리 치료"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["폐쇄 환경에 의한 밀집생활을 피함"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
          {
            name: "공수병",
            english: "Rabies",
            explain: [
              "광견병. 주로 1~4월에 발생하며 공수병바이러스감염에 의해",
              "뇌염, 신경증상 등중추신경계 이상을 일으켜 발병 시 대부분 사망하는 인수공통질환",
            ],
            elements: [
              {
                title: "원인균",
                text: ["Rabies virus"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [
                  "일반적으로 바이러스의 1차적 병원소는 야생동물로서 너구리, 오소리, 여우, 코오테, 스컹크, 박쥐 등이 대표적이며",
                  "사람과 직접적 접촉에 의해 감염시키거나 개, 소, 고양이등과 싸우는 과정에서 이들을 감염시키고 감염동물들이 다시 인간을 물어 감염",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: ["13일~2년"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "머리에 가까운 부위에 물릴수록, 상처의 정도가 심할수록 증상이 더 빨리 나타남",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "발병추기 불안감, 두통, 발열, 권태감, 물린 부위의 감각이상 발생",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "중추신경계 증상이 나타나고 2~6일 이내에 섬망, 경련, 혼미, 혼수에 이르며 호흡근 마비 또는 합병증으로 사망",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [
                  {
                    title: "공수병위험(예상지역)",
                    text: [],
                    list: [
                      {
                        title: "서울",
                        text: ["은평구, 종로구, 강서구, 서대문구"],
                        list: [],
                        emphasize: [],
                      },
                      {
                        title: "경기도",
                        text: [
                          "파주시, 고양시(일산구, 덕양구), 동두천시, 연천군, 포천군, 가평균, 양주군, 하남시, 구리시, 부천시, 의정부시",
                        ],
                        list: [],
                        emphasize: [],
                      },
                      {
                        title: "강원도",
                        text: [
                          "속초시, 철원군, 화천군, 양구군, 인제군, 양양군, 고성군",
                        ],
                        list: [],
                        emphasize: [],
                      },
                    ],
                    emphasize: [],
                  },
                ],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["애완동물에 광견병 예방접종을 실시"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["애완동물과 야생동물의 접촉을 방지함"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "동물에 물렸을 경우에는 즉시 비누를 이용해 흐르는 물에 상처를 씻음",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "해당 동물이 광견병 바이러스에 감염되었으 가능성이 있다면 광견병에 대한 면역글로불린과 예방백신을 접종",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
          {
            name: "디프테리아",
            english: "Diphtheria",
            explain: [
              "호흡기 점막과 피부의 국소 질환이 특징, 예방접종으로 1987년 이후 환자가 발생하고 잇지 않지만 주의가 필요",
            ],
            elements: [
              {
                title: "원인균",
                text: ["Corynebacterium diphtheriae"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: ["환자나 보균자와 직접 접촉 및 분비물을 통한 간접간염"],
                list: [],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: ["2일~6일"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["삼출물에 의해 인두부를 덮는 특정적인 막이 발생"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["코, 인두 및 편도, 후두, 결막, 피부 등에 침범"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["상부기도를 침범시 호흡곤란으로 사망할 수 있음"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "합병증: 인후편도염, 후두염에 의해 기도폐색, 심근염, 신경염에 의한 마비",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "예방접종",
                text: [],
                list: [
                  {
                    title: "기초접종(DTaP)",
                    text: ["생후2, 4, 6개월"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "추가접종(DTaP)",
                    text: ["생후 15~18개월, 만 4~6세"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "추가접종(Td)",
                    text: ["만11~12세"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["정해진 시기에 예방접종을 실시"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["환자와 직접 접촉을 피함"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["환자가 사용하거나 분비물에 오염된 물품은 소독"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
          {
            name: "조류인플루엔자 인체감염증",
            english: "Avian influenze in Human",
            explain: [
              "조류 인플루엔자 바이러스(Avian influenza A(H5N1)) 감염에 의한",
              "급성 호흡기감염병",
            ],
            elements: [
              {
                title: "원인균",
                text: ["H5N1 virus"],
                list: [],
                emphasize: [],
              },
              {
                title: "감염경로",
                text: [
                  "조류인플루엔자에 감염된 조류의 배설물에서 배출된 바이러스가 사람의 코나 입으로 침투하여 감염",
                ],
                list: [],
                emphasize: [],
              },
              {
                title: "잠복기",
                text: ["3일~10일"],
                list: [],
                emphasize: [],
              },
              {
                title: "주요증상",
                text: [],
                list: [
                  {
                    title: "",
                    text: ["38℃이상의 갑작스러운 발열, 기침, 인후동 등"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "일반독감과 유사한 증상을 보이며 시간이 지나면서 호흡곤란 등이 발생, 심하면 합병증으로 사망",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "감염방지를 위해서",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "닭이나 오리를 사육하는 사람은 작업 시 장갑이나 마스크를 착용",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["작업이 끝난 후 샤워 등으로 개인위생 철저"],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "사육중인 닭이나 오리 등 조류가 이상 증세를 보이면 즉시 방역당국에 신고",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "조류인플루엔자가 발생했던 농장의 근무자나 가금류의 처리에 참여했던 사람이 마지막 노출 수 7일 이내에 고열 등 호흡기 이상증세를 보이면 방역당국에 신고",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "조류인플루엔자 발생지역 여행시 가금류, 조류 등의 사육농가나 판매장의 방문 금지",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "조류인플루엔자 발생지역 여행시 방문 2주전 예방접종 실시",
                    ],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
              {
                title: "발생지역",
                text: [],
                list: [
                  {
                    title: "",
                    text: [
                      "가금류 발생지역: 동남아와 중국, 러시아, 카자흐스탄, 몽고, 터키, 우크라이나, 루마니아, 크로아티아 등",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: [
                      "인체 감염국: 베트남, 태국, 인도네시아, 캄보디아로 인체감염자는 121명 발생, 62명 사망하여 치명률이 51%임.",
                    ],
                    list: [],
                    emphasize: [],
                  },
                  {
                    title: "",
                    text: ["우리 나라는 아직 사람에게 감염된 사례는 없음"],
                    list: [],
                    emphasize: [],
                  },
                ],
                emphasize: [],
              },
            ],
          },
        ],
      },
    ],
  },
  getters: {},
  mutations: {},
  actions: {},
};

export default aboutStore;
