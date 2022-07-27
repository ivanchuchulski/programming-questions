#include <iostream>
#include <cmath>

using namespace std;

struct Point 
{
    float x;
    float y;

    bool operator==(const Point& right) const
    {
        return this->x == right.x && this->y == right.y;
    }
};

struct Circle
{
    float radius;
    Point centre;

    bool operator==(const Circle& right) const
    {
        return this->centre == right.centre && this->radius == right.radius;
    }
};

enum class RelativePosition : unsigned short
{
    NO_COMMON_POINTS = 1,
    TOUCHING = 2,
    INTERSECTING = 3,
    SAME = 4
};

class Solution
{
public:
    RelativePosition find_relative_position(const Circle& first, const Circle& second)
    {
        if (first == second)
        {
            return RelativePosition::SAME;
        }

        float distance_between_centers = euclidean_distance(first.centre, second.centre);
        float radii_sum = first.radius + second.radius;

        if (distance_between_centers < radii_sum)
        {
            return RelativePosition::INTERSECTING;
        }
        else if (distance_between_centers == radii_sum)
        {
            return RelativePosition::TOUCHING;
        }
        else 
        {
            return RelativePosition::NO_COMMON_POINTS;
        }
    }

private:
    float euclidean_distance(const Point& first, const Point& second)
    {
        float x_diff = first.x - second.x;
        float y_diff = first.y - second.y;

        return sqrt(x_diff * x_diff + y_diff * y_diff);
    }
};

int main()
{
    Circle c1 {10, {0, 0}};
    Circle c2 {c1};
    Solution sol;

    cout << (unsigned short)sol.find_relative_position(c1, c2) << endl;

    return 0;
}