def baseUrl = 'http://localhost:8080/app/rest/user/register'

def users = [
    "西沢 麗奈",
    "大内 英充",
    "北原 荘介",
    "北島 晃義",
    "冨田 義勝",
    "永野 厚史",
    "嶋田 友美",
    "平川 道正",
    "古谷 祥三",
    "安井 三光",
    "佐野 友良",
    "内田 茂俊",
    "久保 宗市",
    "島田 幸四郎",
    "河野 慶太郎",
    "今村 秀司",
    "坂田 武士",
    "大山 保光",
    "栗田 雅栄",
    "竹内 梨絵",
    "金城 志奈",
    "岩井 信也",
    "米田 輝政",
    "竹下 家継",
    "三浦 一典",
    "関 愛次郎",
    "黒田 智子",
    "白石 訓",
    "前川 顕子",
    "篠崎 孝市",
    "藤川 絵梨",
    "内海 慶太郎",
    "神谷 勝弘",
    "石崎 季孝",
    "内藤 久作",
    "古賀 義将",
    "小出 松代",
    "岡 義勝",
    "高野 恵",
    "寺田 百世",
    "中井 菊治",
    "石原 亀男",
    "松村 沙耶香",
    "永田 美海",
    "小山 佳江",
    "稲田 善二",
    "藤井 保光",
    "田原 信也",
    "吉沢 正征",
    "藤野 亮子"
]

users.eachWithIndex { user, index ->
    def name = user.split(" ")
    def lastName = URLEncoder.encode(name[0], 'UTF-8')
    def firstName = URLEncoder.encode(name[1], 'UTF-8')

    def cookieFile = "cookie${index + 1}.txt"

    def process = "curl -i -b ${cookieFile} -c ${cookieFile} ${baseUrl}?firstName=${firstName}&lastName=${lastName}".execute()
    def text = process.text
    process.waitFor()

    println(text)
}
