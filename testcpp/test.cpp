#include <iostream> // 标准输入输出流库
#include <algorithm> // 标准算法库
#include <iomanip> // 输入输出流操作库
#include <vector> // 向量（动态数组）库
#include <set> // 集合库
#include <cmath> // 数学函数库
#include <cctype> // 字符处理函数库

using namespace std; // 使用标准命名空间
typedef long long ll; // 将long long类型重命名为ll，方便使用

int main(void)
{
    ios::sync_with_stdio(false), cin.tie(0), cout.tie(0); // 优化输入输出，关闭C风格的同步，解绑cin和cout

    ll n, m, k; // 定义长整型变量n, m, k
    cin >> n >> m >> k; // 输入n, m, k的值
    vector<vector<char>> mm(n + 5, vector<char>(m + 5, 'X')); // 定义字符二维向量mm，初始化大小为(n+5)*(m+5)，初始值为'X'
    vector<vector<int>> nn(n + 5, vector<int>(m + 5, 0)); // 定义整数二维向量nn，初始化大小为(n+5)*(m+5)，初始值为0

    // 输入矩阵的内容，使用'O'和'X'表示
    for (int i = 1, ai; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            cin >> ai; // 输入矩阵元素
            if (ai)
                mm[i][j] = 'O'; // 如果元素值不为0，设置为'O'
        }
    }

    ll x, y; // 定义长整型变量x, y
    char c; // 定义字符变量c

    ll num = k; // 保存最初的k值
    ll last; // 定义长整型变量last
    char ch; // 定义字符变量ch
    while (k--) // 循环k次，处理每一个命令
    {
        cin >> x >> y >> c; // 输入坐标(x, y)和字符c
        nn[x][y] = num - k; // 将当前操作的编号存储在nn矩阵中

        if (mm[x][y] != 'O')
            continue; // 如果当前坐标不是'O'，跳过本次循环

        // 处理上下左右的字符转换
        if (c == 'u' && islower(mm[x - 1][y]))
            mm[x - 1][y] -= 32; // 如果c是'u'并且上方字符是小写字母，则转换为大写
        else if (c == 'd' && islower(mm[x + 1][y]))
            mm[x + 1][y] -= 32; // 如果c是'd'并且下方字符是小写字母，则转换为大写
        else if (c == 'l' && islower(mm[x][y - 1]))
            mm[x][y - 1] -= 32; // 如果c是'l'并且左方字符是小写字母，则转换为大写
        else if (c == 'r' && islower(mm[x][y + 1]))
            mm[x][y + 1] -= 32; // 如果c是'r'并且右方字符是小写字母，则转换为大写
        else
        {
            mm[x][y] = c; // 否则将当前坐标设置为c

            last = 0; // 初始化last为0
            ch = '.'; // 初始化ch为'.'
            // 判断上下左右的字符并更新last和ch
            if (mm[x - 1][y] == 'd' && last <= nn[x - 1][y])
            {
                last = nn[x - 1][y];
                ch = 'd';
            }
            if (mm[x + 1][y] == 'u' && last <= nn[x + 1][y])
            {
                last = nn[x + 1][y];
                ch = 'u';
            }
            if (mm[x][y + 1] == 'l' && last <= nn[x][y + 1])
            {
                last = nn[x][y + 1];
                ch = 'l';
            }
            if (mm[x][y - 1] == 'r' && last <= nn[x][y - 1])
            {
                last = nn[x][y - 1];
                ch = 'r';
            }
            // 根据ch的值，进行字符的转换和更新
            switch (ch) {
            case 'u': mm[x][y] -= 32, mm[x + 1][y] = 'O'; break;
            case 'd': mm[x][y] -= 32, mm[x - 1][y] = 'O'; break;
            case 'l': mm[x][y] -= 32, mm[x][y + 1] = 'O'; break;
            case 'r': mm[x][y] -= 32, mm[x][y - 1] = 'O'; break;
            };
        }
    }

    // 输出最终的矩阵状态
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j < m; j++)
            cout << mm[i][j];
        cout << mm[i][m] << endl;
    }

    return 0; // 返回0，程序结束
}
