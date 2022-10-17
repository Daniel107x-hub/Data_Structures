package com.problems.trees.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class SearchSuggestion {
    public static void main(String[] args){
        Trie trie = new Trie();
        String[] input = {"gbhikfqitgulfimbtciodeuenmxfcfxpspcntlfmxkckwngixkcwrm","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlqphnr","gbhikfqitgulfimbtciodeuenmxfzduzqkmxlxxnu","onehhucjjnusypmntezyplkhdjtsiddqnisqgbgjumtzzfvxy","cvljzdhhjjkvlldkzagtedoiapatbazjcu","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbcs","gotyhlemxndfxwnhumznzoyfic","etwjnqwbqfxziuudbgwtovulqu","gbhikfqitgulfimbdqrgaccxsydpifhazlsguskhiyiikaywcdzqzkhmgg","gbhikfqitgulfgjpiyuxrejlpqeszsxret","gbhikfqitgulfimbeycwkfupzbxceivesamwdurxezrhlohxl","ayiqhmoyuxlagsjpymfrfilaimbrvddloalbtsbsdlkxaihfmrybcfl","gbhikfqitgnockicpvgx","eefmxuwvkrlisuitqnmnkjdcvbhkzjbttnhzjzchmvndmbbszmfx","gbhikfqitgulfimbtciopppzsgso","gbhikfqitgulfimbtciodeuenmxfcfxpspchiptkywcwk","gbhikfqitgulfimbtcimlginegvlrhiowsoujtdhtxs","wtycgrhgyknydbimddbkotvowvmpccosrlvprmuvinyqvyhsywkjrfuqc","gbhikfaszchnnynleoj","gbkagsscwmbxzzjhumvppxsv","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosftion","gbhikfqitmatmunpjmzqjfpbiuulnrchdadktdnyobslek","qoaytmjpqhykanrptuwiklkfsvvbwperapemvtbsppooexi","wrfepaxafrnjfpkfankmdqhizlblcddrxfmgrsedov","ufrafothretyazyczyjjvdizxlhcus","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalcqiquixsx","apjcvknmujqviwypyumxiraugnmpkmgdgtviphsddechyitdwhqsxmlv","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalcqiquixf","dumuktpilvynbtzxhkxyeuebatwqmvkrz","quejnbodngqxlpgwjx","diftkkkfzlwuwywckhjxq","yhugufpbmxlpcmrbmkpdsztctzvfxmdklkdrfkmddhoqniduaxcaufspv","gbhikfqitgulfimbtciorlyobxrpkk","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbbptw","fwpbkxyrywpijywlepzsgunwiqlxtnljzhei","kqndmmmogjynp","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalcqiquixw","kkjzmhhnflckervig","ytgfycqnuxiejv","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalcqiquixcdb","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalcqskaw","gbhikfqitgulfimbtciodeuenmxfcfxpspcnhpsnbmzyhnl","gbhikfqitgulfimbtciodeuenmxfcfxpstxqjcdnjhvqbpjwhgowodn","nhgxyphvra","jkwbdiskgcjegywcrntckxvqilizrfcdzmbriubsf","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmvgkrvppfthiap","gbhikfqitgulfimyyfoebbzatgclswcsixicoemoqtino","gbhikfqitgulfiipi","dpfthrzgclogkfgf","farrpzkfcmsloukluxzfrdioxarehxirrufshglcjgqkoljgdfd","gbhikfqitpsws","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalcqim","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbakrkfypuxy","gbhikfqitgulftyvysyi","uazfmcimymvhdvctgllggtjhbjdpjzapehzawwqsnqyr","gbhikfqitgulfimbtciodeuenmxfcfxpspcngyssvbszsohipo","gbhikfqitjpqnbopq","hvceesxwaxl","nimallitntpyqqcgtwqklphuggnalpfwauxbifuglkniiwhiriohhn","jhqvkbnrbzkv","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosbjnvyk","asdqkzkhgfcjffek","zameehphqadrxkl","htwgzuqrqocvwmj","gbhikfdzhvwgejzsnwxfprsjy","aahcedueadblveqbuqoqplhgmdotlmaad","yieeadlgtdlxkoypgjryumodxemrjsgncxskdcdhfiptbghti","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlldvvg","usjriqepqtgzugfyopvnpucizuxwvwcqgpaipghgfivbipts","qccnpyzqqjwrnzeqsqgyuglroprbtnkvlospgc","gpk","gbhikfgjulpogmntgqmyuaudggyfjgjmwsnugjqcvbvtxh","gbhikfqitgulfimbtciodeuenmxfcfxrvzaquglvyzmcjtcamtpxsqubi","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmgyito","gbhikfqitgulfimbtciodeuenmxfcfxpspcntfnedkyvjljgfxu","xgtpqzrmisviniaadngmmonqejolwpiooj","gbhikfqitgufnfbagrnudvxdznjldobfrqzhdzjjxviyfffg","wannouhzkksghxmfdrhicijvxpctswpgfmlttxbqpmsngwdnakc","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaodswao","gbhikfqitgulfimbtciodeuenmxfcfwkxwdrikjbhsrwqibylk","ivxlrxpmbrhzitoisprhgzmnvrlwsnbmklezaglbwtgqx","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalcqiquixcz","pindlo","tytiqgibdblbwwixpwigaimteeddegddbrcyqbenoexmyanoj","jvvs","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlbbgpzdaxzbrdvw","gbhikfqitgulfimbtciodeuenmxycpjz","gbhikfqitgulfimbtciodeuenbsiimdnaklkerjbiovkzruaqzkke","gbhikfqitgulfimbtciodeuenmxfcfxpspcntqr","qpaebfjrnsxisriftktwowujawumsbfvfsjqpfcmpstdk","gbhikfqitgulfimbtciodeuejbpqfvbedealcrgef","vjcd","umsahovtdhhbbhfelklnugidakgagevmneblmguuchgygpfopkse","gbhikfqitgulfimbtciodeuenmxfcfxpjydpfakzqcducfjbd","clsrpjllmzdlwxl","gbhikfqwlhdousfwccbpharlexpijtsypp","gbhikfqitgulfimbtciodeuenmxfcfxlzhdqltjumgpalwfzoyaj","lespexmrbkxleyvhedjzbrjkqddguupcofnh","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbzu","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalcqiqusvj","spkrfnbdjzvjcktzgijpvssredyhypusphhanjeppiljxwr","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalcqiqudn","ywuhqfmjgaoesdibfstiouafojwiwvlnggerdcslp","gbhikfqitgulfimbtciodeuenmxfcfxpspcnregntlyiyhgphn","gbhikfqitgulfimbtciodewehknbhmwcjiwhitrxqhbw","gbhikfqitgulfimbtcioejsmkqzdmwh","ypifexniufooeelkwwzzgv","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbhuqp","hljacqhesnkqiazonopuogrifjbexz","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaoqqy","sehrnahzrgdhb","weccsolxokleyakmsmkazufwgbvwczrapoubgto","gbhikfqitgulfimbtciodeuenmxfcfxpsaermptyjxrjkdyedrohrdmc","gbhikfqitgulfimbtciodeuezpcjsdgqyalqsmpfns","gbhikfqitgulfimbtciodeuenmxfl","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosxzmy","tsknfglyxmvfwzjhqaurrcvvqjcxlgihwxiujsvkswyhcsq","rmdwngxzmmnvljzmawdexjhbxwqolwplazchv","gbhikfqitgulfimbtcihgecvnknalgpovv","gbhchnndolvxkbjlok","gbhikfqitgulfimbtciodeuenmxfcfxpmyyhxbmitatgbtsvdruay","gbhikfqitgulfimbtciodeuenmxfcfxpspcntgvphjlmpjaztvp","xpisiqstjmsnoepahjklatlrmy","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalcqibcjx","gbhikfqitgulfimbtciopckbvwikqxbmgnhfpkfiimwpwgga","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlcmrnumqtisrvlp","urrygohbhtuqhmlkyldbrhzqnxraafzt","phaqerwktxczdkd","gbhikfqitgulfimbtciodqclhgvkxlz","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalcqiquixcdx","gbhikfqitgulfialltbybydwybodiknumxuownopbyngcm","udkehouvlhjnqlfsxsykcbreuqorzaxsqupvwfizwqatlq","sicdrbpboifjfclsvnlqp","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalcqiquiz","gbhikfqitgulfimbtczbxwkrqvwasgppaahroonuca","rgskaojajgijgmkyscpqzdlrdwrguaxnhdvafujoixm","eregqenvamjboinbigef","fw","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalpsjgh","gbhikfqitgulfimbtcigxyrpaslmgtivkytjybomtdhghv","kettzwgkjufrodhpgikhlgohfwmygxeyqaofauinlobkpxsyaffpdfarc","butxqcnzosgylkuzpvjissyswmekzrfucizfboehevhw","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmscl","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalea","gbhikfqitgulfimbtciodeuenmxfccz","gbhikfqitgulfimbtciodeuenmxfcfxpsblcatreadktfmwkqnrnlm","gbhikfqitgulfimbtciodeuenmxfcfxaybwugumwmptaignqeb","rlojeifxxgfvxviyqqlyw","vnbqalofvabnjeoohbvtzgvbcwlciekjmsqsligkivlvziiyjkzqdhribn","pkm","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlyasirfdysvhm","gbhiblcdbixllocehkcliaedyfvmfknyevxvzukusktmyo","ubxwbsmmdfxzbrcsvfvsnkjnkdgvlsarfex","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalcqiqsdo","qevqyewbejkthofluuac","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbaiqnvjl","gbhikfqitgulfimbtciodeuenmxgpdg","gbhikfrapjetyndarcshxqmasgnxduqkzqenwykmvieksdtgpavxsirkhu","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmylni","gsyjhluoctbh","gbhikfqitgulfimbtpzuroxhphswzetbnjhxmzgyenxpjydcse","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosjiqctyqub","jkfixoscerdufnbenrhbheijgqlotkiceyoidxykclz","gbhikfqitgulfihzxsfyqocuifo","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmfhernpynts","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalmuintikec","ruukabvhjpkhskzttl","gbhikfqitgulfimbtciodeuenmxfcfxpspcnth","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalcoqeyyzss","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlppzzrtiilaekbnp","gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbajqo","gbhikfqitgulfimbtciodeuenmxfctfm"};
        String searchWord = "gbhikfqitgulfimbtciodeuenmxfcfxpspcntlgmbmaosfbalcqiquixcdbklvdoxdempjiqrutqatqlniuiduvmgpwxkkvliwivlpxhmtqqyevlbfiwhigrdnhcgfnczseujqexnjtjvfwusmoitbnjqzqcfqpjvbuqpptjmymwwzjmmnjhktosivvijxykllmyrjziwtfvknzlddbp";
        addWords(trie, input);
        List<List<String>> results = emulateTyping(trie, searchWord);
        System.out.println(results);
    }

    public static void addWords(Trie trie, String[] products){
        for(String product : products) trie.addWord(product);
    }

    public static List<List<String>> emulateTyping(Trie trie, String word){
        List<List<String>> results = new ArrayList<>();
        StringBuilder string = new StringBuilder();
        for(char letter : word.toCharArray()){
            string.append(letter);
            List<String> partialResults = trie.search(string.toString());
            results.add(partialResults);
        }
        return results;
    }

    private static class Trie{
        private Node root;

        public Trie() {
            this.root = new Node('*');
        }

        public void addWord(String word){
            Node current = this.root;
            for(char letter : word.toCharArray()){
                if(current.getChildren() == null) current.setChildren(new TreeMap<>());
                if(current.getChildren().containsKey(letter)) current = current.getChildren().get(letter);
                else{
                    Node newNode = new Node(letter);
                    current.getChildren().put(letter, newNode);
                    current = newNode;
                }
            }
            current.setFinal(true);
        }

        public List<String> search(String prefix){
            Node current = this.root;
            SortedMap<Character, Node> children;
            for(char letter : prefix.toCharArray()){
                children = current.getChildren();
                if(children == null) return Collections.emptyList();
                if (children.containsKey(letter)) current = children.get(letter);
                else return Collections.emptyList();
            }
            return search(current, prefix.substring(0, prefix.length() - 1), new ArrayList<>());
        }

        public List<String> search(Node current, String prefix, List<String> words){
         if(current.isFinal()) words.add(prefix + current.getValue());
         if(words.size() == 3) return words;
         if(current.getChildren() != null){
             Iterator i = current.getChildren().keySet().iterator();
             while(i.hasNext() && words.size() < 3){
                 search(current.getChildren().get(i.next()), prefix + current.getValue(), words);
             }
         }
         return words;
        }
    }

    private static class Node{
        private char value;
        private boolean isFinal;
        SortedMap<Character, Node> children;

        public Node(char value) {
            this.value = value;
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }

        public boolean isFinal() {
            return isFinal;
        }

        public void setFinal(boolean aFinal) {
            isFinal = aFinal;
        }

        public SortedMap<Character, Node> getChildren() {
            return children;
        }

        public void setChildren(SortedMap<Character, Node> children) {
            this.children = children;
        }
    }
}
