package interviewBit.strings;

import java.util.ArrayList;

public class DeSeralize {
    public ArrayList<String> deserialize(String A) {
        String [] split = A.split("~");
        ArrayList<String> res = new ArrayList<String>();
        for ( String str : split) {
            int lastIndex = str.length();
            for ( int i = str.length()-1; i >= 0; i--) {
                if ( str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    int len = Integer.parseInt(str.substring(i));
                    if ( len == i )  {
                         lastIndex = i;
                         break;
                    };
                    continue;
                }
            }
            res.add(str.substring(0,lastIndex));

        }
        return res;
    }

    public static void main(String [] args) {
        ArrayList<String> res = new DeSeralize().deserialize("czlojmksuoqjsszifzvlqciqbdaifyrfvgmhlfgdl41~ytnkwwqkcctowotaqfdhqwuiikwsgclnswbluysoq41~wanwoqllzjyjmuayssokbqqsdsjzjdomzlitykbjt41~vejcgdchngysewlxxofuxphefqfnihqouynoyizkh41~skcqarryswtbkxayevhuogktoddxgqrlkocufsaeg41~ejplayvqphvvrmdvtcqlkddtnicdddxtajxmipqyd41~soadabkmvfuylvdnkpnygvharlnebvqmsfityvbhc41~atmiowcwymbkkiypoagftctetrslhuwofqixvvtcl41~quauampcbylcpeamrgjgawynbelcgcdykxakaczbu41~fikraqqdbdncjrqgcfmjqzodsevuvbmcvpfmprnmu41~vbpjvsvwgxedqhqkqbfvtvjwxoouxntinplscbpuk41~edhmykwfabzdddsfiestoiqotndedqtbevrylcmrh41~jqdyaogxsscnfnavnurmmeauwtqyszsqtaqzjpfll41~yfxvnxgvrlpdgmheiefeyoywwvavdrqgpakaspdpv41~lsjvajbukzuvmfbiaayktnbadxabruirguyifidqd41~sedmwzhzfxaliejuggdqojwpkxygutkyvqdmjmlvt41~pwwifiiwoxdcdjhwzeepkzqwtrhcpifscdazwofso41~gudqepaowfzxvfvlmdfplpgnprdssqulvtjuysvwj41~irdwqqkpkscmbpkjfiflalahzxwqvhecmqbwyicup41~bhbothcjxtibvkeiczwgbothncdkyimjwnwpflvmt41~kabuzeivspkweywhesorubqrawxapbqifrrjtiqdp41~ptpdlbjcsluwaebdxcynxddugbzeoeyoxzcrjjwxi41~pqxthapklmcrsrkuhmnznvvetfnbdulqqtpjxzpua41~xtcacgsecmcjyokyxuwfidwsjdhwpixlfgxybpjrj41~hvyjsyrunoynywcehrcywybjocbnnkvkqihjnbumo41~rpsqolkvyodnsltikcjggpqsreyclborvlvqinbwy41~nscvrevpbopvkprvothmjnaisqtvcaubkbukbrdie41~riyvnxaxzpnlmevrnvkgqdbyjiozhaayfdfxdiflp41~hwhyjyhorzppnffelikerocpuiqdjxposuliorqsw41~xprspkuybollsrpoyjdukkwtrayeeyrmgaoumpsxt41~qmrellhuqgeuecpukuiizquigcdhtxioheojfsivh41~nkazfjdkxbfowaaautxiszmjszfuhgtbzpibictml41~tfqdrkookaowwfaenrwpqpvonfsdwxhwtvebgqizs41~mnwtzypfgkzcqudybwosstgazniwspofxgygbybib41~jrddtjeqglczffbujuvdcwdfbhbyqjdixzqwczpop41~iveamiodzeubmwscafohybsmodlriupwdwotpdwoj41~gmpeelydxgecshqpxiuaqusyycoxopkhljeaovatv41~alswusunbmisldghlkxumtpnduhpvpvebqzwdpvmf41~itjezidhsrtwafudmtvihcrnooybogbtnoxsjmcbc41~insnlhxddhywcgkwhlllvrppvcfhgaxvhljrtrzem41~zyihibrigvjluseaevjxrpqwjyltnjgxtucxrhbpw41~");
        for ( String str : res) {
            System.out.println(str);
        }
    }
}
