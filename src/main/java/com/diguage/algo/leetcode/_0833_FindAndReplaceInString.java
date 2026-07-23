package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _0833_FindAndReplaceInString {
  // tag::answer[]
  /**
   * 回头得重写一遍！
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-23 21:52:43
   */
  public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
    List<Data> data = new ArrayList<>(indices.length);
    for (int i = 0; i < indices.length; i++) {
      data.add(new Data(indices[i], sources[i], targets[i]));
    }
    data.sort(Comparator.comparingInt(a -> a.index));
    List<Data> filter = new ArrayList<>(indices.length);
    for (int i = 0; i < indices.length; i++) {
      Data d = data.get(i);
      // 找到才处理
      if (s.startsWith(d.source, d.index)) {
        // 没有则直接添加
        if (filter.isEmpty()) {
          filter.add(d);
        } else {
          Data last = filter.getLast();
          // 判断和前面一个是否重叠
          if (last.index + last.source.length() - 1 < d.index) {
            // 不重叠
            // 前面一个无效，删除
            if (!last.filter) {
              filter.removeLast();
            }
            filter.add(d);
          } else {
            // TIP: 题目保证不会有重叠的！仔细审题啊！
            // 有重叠
            // 判断哪个更靠后，则保留哪个
            if (last.index + last.source.length() < d.index + d.source.length()) {
              filter.removeLast();
              d.filter = false;
              filter.add(d);
            } else {
              last.filter = false;
            }
          }
        }
      }
    }
    if (!filter.isEmpty() && !filter.getLast().filter) {
      filter.removeLast();
    }
    if (filter.isEmpty()) {
      return s;
    }
    int index = 0;
    StringBuilder sb = new StringBuilder();
    for (Data d : filter) {
      sb.append(s, index, d.index)
        .append(d.target);
      index = d.index + d.source.length();
    }
    if (index < s.length()) {
      sb.append(s, index, s.length());
    }
    return sb.toString();
  }

  private static class Data {
    int index;
    String source;
    String target;
    boolean filter = true;

    public Data(int index, String source, String target) {
      this.index = index;
      this.source = source;
      this.target = target;
    }
  }
  // end::answer[]

  static void main() {
    new _0833_FindAndReplaceInString()
//      .findReplaceString("vmokgggqzp", new int[]{3, 5, 1}, new String[]{"kg", "ggq", "mo"}, new String[]{"s", "so", "bfr"});
//      .findReplaceString("wreorttvosuidhrxvmvo", new int[]{14, 12, 10, 5, 0, 18}, new String[]{"rxv", "dh", "ui", "ttv", "wreor", "vo"}, new String[]{"frs", "c", "ql", "qpir", "gwbeve", "n"});
      .findReplaceString("ydrctlphryrwcelwquhlqpmrqaxgbfvwtnrvbaptfjkodhhivbwclspjldxaxwipwlfglbghdulrqxdcpxaptezogttqatiwujhwzpuveurnwsjdaqqnpfyuvihgagjyqnkmmwmsyxqjzfzvlnzzowxrjksohubkaoaeukvcomvbmcslumnndindhfuumhieoxxxshpygaivfpbjkksdpxaocdyppyjztawvbqkbioorfjfetowrblcycfnxvjriobxbyztnrtjrshwnwjxqacmcztxwajcagohobrmvrjzafijyfnphdibpjatzxhvtpselqatxkkxdqpmjspsqytdtkfgnybrxarmwvhmyesbibmxeftdoyefryydzzaedbmfwqjcqtrblrygelluoekdbpfalukhammbbaasjelbmmxxrktjxbnccpddnztxhpclghyeylioqqtzhadrtpgdcyemiojhmbqgafzlyvzuhrwturhqucmrjwkqvlrusrydduteizxzokldsyxihecrknfwjmobuxlhaxabylagfwpmkoslypcdwmpswjhapgmkwjusvikefkfvhjpwopupcatnvhyvhwyoitgwqpopljuikjodgqbqrsxmyffwriqxvpkbhrekbqoyknoejjnrhgkgpomvehdjqhebpwewlxihoxyyjjtyrbgrekypsgxyhhpxkjbakmklmmfqmwvmkkxmhlaqvhvecsvcjbrzablsycmhsiujjresmwecollpoomwzspdoqhngtpdjoplxoirerfuwizbydnltrjrmjetwyouckwhkkgulntgxbyqdvrlayykercdbghwtwcfspnlxxklltgeoyvlybjsninsqahkjhdwpdqeffqtsvamvctturqqpjptxxkvtsleceksbsixdlstlznwmzixqpbnimklaxpuqeamlsljogqweklklbuposawltjpnwzqigvpybhvmvjcskohs", new int[]{833, 829, 166, 605, 312, 581, 455, 254, 559, 505, 670, 284, 694, 90, 592, 916, 588, 628, 194, 434, 62, 564, 953, 751, 599, 962, 491, 673, 654, 184, 700, 338, 288, 790, 146, 0, 521, 354, 38, 264, 960, 7, 900, 873, 191, 530, 840, 111, 54, 211, 704, 862, 643, 227, 120, 892, 987, 382, 536, 324, 939, 496, 244, 446, 838, 125, 663, 58, 365, 740, 615, 219, 52, 68, 508, 717, 27, 268, 685, 168, 970, 846, 824, 882, 635, 696, 976, 910, 304, 776, 397, 390, 276, 805, 545, 809, 151, 990, 224, 458}, new String[]{"yqdvr", "tgxb", "vc", "yvhwyoit", "jatzxhvtpse", "usv", "yli", "riobx", "kosly", "kq", "ve", "ajc", "yr", "tqatiwujhwzpuveurnw", "jpw", "sleceks", "kf", "qbqrs", "xx", "jxb", "ip", "pcdwmpswjhapgmkw", "am", "ycmhsiujjresmwecollpoomwz", "catnv", "weklk", "hrwt", "djq", "yknoejjn", "hfuumhi", "kyps", "sqyt", "gohobrmvrjzafijy", "lxoirerfuwi", "zzowx", "ydrct", "xzokld", "mwvhmyesbib", "ptfj", "rt", "gq", "hryrwcelwqu", "ctturqqpj", "jsnin", "eo", "ihecrk", "yyker", "da", "pj", "dpxa", "gxy", "lltge", "vpkb", "vbqkbioor", "vih", "fq", "ybh", "ed", "nf", "qat", "qpbnimklaxpu", "rhqucm", "blcycfn", "xhpcl", "la", "gjyqnkmmwmsyx", "hgkg", "xax", "mxe", "svcjbrzab", "qpoplj", "ppyj", "ls", "lbghdulrqxd", "lrusryddu", "klmmfq", "gbfvwtnrvba", "shw", "ih", "omvb", "pos", "dbghwtwcfsp", "kguln", "kjhdwp", "yffwriq", "bgr", "tj", "txxkvt", "fnphdibp", "sp", "ygelluoekdbpfalukhammbbaasjelbm", "cqtrb", "acmczt", "nltr", "lhaxa", "jrmjetwyou", "rjksohubkao", "vmvjcskohs", "ta", "oqqtzhadrtpgdcyemiojhmbq"}, new String[]{"yylryi", "fgllo", "fwl", "kdhuhxvzr", "cvqhuzuoqy", "uia", "jjr", "vqfu", "cmwv", "hsi", "q", "qu", "v", "vvdcranjoawfmfrlmwx", "ytpw", "bedngobl", "sb", "zivt", "l", "wg", "g", "xxfnekbbvfbttmsaz", "s", "orsnfdemeugdbrhxoeqdrykhr", "ajbovn", "dglsi", "lfr", "dl", "dvmlejzh", "cqvogr", "vzimb", "bajwe", "jarxzfmrvrctxmud", "fysddvymir", "zhnopi", "khtyxs", "liqpp", "dtuacadhptc", "ubzur", "usa", "cu", "wuozjmtdatau", "utztuhspo", "aymcuy", "eeq", "onjmpw", "adje", "m", "jsn", "fsxsg", "kup", "esad", "fyq", "urtlewdiuy", "jxdh", "um", "bki", "gt", "f", "sxwa", "tfyoddzwkdvfl", "ffcwxtq", "jwkxzs", "tnnid", "f", "viudpwckuiue", "vctgw", "wd", "oki", "jzxxdilvxo", "gtatiw", "jtb", "hm", "ivfytknzvz", "aafzwoxoiw", "wdjkt", "zwdzijemosr", "tlsn", "j", "pdcck", "agnc", "xplpczgqpz", "ieinaw", "uyrmwuk", "adfardf", "wo", "e", "hxwgk", "owrxbdopw", "ml", "srfofdjqkcmpjtltzeuyfpvkgaudadx", "xqhay", "bnwnlrr", "xrqc", "zbiua", "zrxdspxjx", "tavesyitod", "bebfxxjat", "j", "iqvluqothwqbbygwrgeasavr"});
  }
}
