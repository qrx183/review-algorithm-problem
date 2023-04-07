package codetop_byte.q0407;

public class Rand10 {
    public int rand7(){
        // 这是一个给出的生成[1,7]内的随机均匀整数
        return 1;
    }
    // 理论上可以用randX 构造出任何一个 randN ,只需要构造多种概率进行拼凑,也可以在拼凑的基础上对某些不符合条件的值予以拒绝
    // 比如rand7 构造 rand11 就可以分别构造1/2 和 1/6 两种情况的概率,然后映射到[1,12]上,然后再拒绝12即可
    public int rand10() {
        // 利用rand7生成rand10的随机均匀整数
        int first,second;
        while((first = rand7()) > 6){} // first的概率是1/6
        while((second = rand7()) > 5){} // second的概率是1/5
        return ((first&1)== 1 )? second : second+5; // first & 1 == 1的概率是1/2,即first是奇数的概率

    }
}
