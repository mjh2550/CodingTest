package Prog.DFS;

public class Solution {
    /**
     * 문제 설명
     * 두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
     *
     * 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
     * 2. words에 있는 단어로만 변환할 수 있습니다.
     * 예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
     *
     * 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한사항
     * 각 단어는 알파벳 소문자로만 이루어져 있습니다.
     * 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
     * words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
     * begin과 target은 같지 않습니다.
     * 변환할 수 없는 경우에는 0를 return 합니다.
     * 입출력 예
     * begin	target	words	return
     * "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
     * "hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0
     * 입출력 예 설명
     * 예제 #1
     * 문제에 나온 예와 같습니다.
     *
     * 예제 #2
     * target인 "cog"는 words 안에 없기 때문에 변환할 수 없습니다.
     */

    static boolean[] visited;
    static int answer = 0;

    public int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];
        dfs(begin, target, words,0);

        return answer;
    }

    public void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {//변환 완료 시(정답 시) answer 리턴, cnt가 0부터 1씩 증가하여 answer이 됨
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) { //완전 탐색을 위해 반복문 사용
            if (visited[i]) {//방문한 적 있으면 다음으로
                continue;
            }

            int k = 0;//같은 문자 개수
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }

            if (k == begin.length() - 1) {  // 한글자 빼고 모두 같은 경우 만 방문
                visited[i] = true;//방문할 시 true
                dfs(words[i], target, words, cnt + 1);//다음 꺼 cnt1 증가시키고, 단어 바꿔서 재귀호출
                visited[i] = false; //복귀 시 해당 index는 무시하고 다음 걸 탐색
            }
        }
    }
}
