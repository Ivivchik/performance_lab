#include <stdlib.h>
#include <crtdbg.h>
#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
#include <cstdlib>
#include <cmath>
#include <vector>

using namespace std;

typedef struct	line
{
	float x;
	float y;
	float c;

}				t_line;

float	**create_array(size_t a, size_t b)
{
	float **m;

	m = new float*[a];
	m[0] = new float[a * b];
	for (size_t i = 1; i != a; ++i)
		m[i] = m[i - 1] + b;
	return (m);
}

void	free_array(float **m)
{
	delete [] m[0];
	delete [] m;
}

int		count_rows(char *av)
{
	int rows;
	string line;

	rows = 0;
	ifstream in(av);
	if (in.is_open())
	{
		while (getline(in, line))
			++rows;
		in.close();
		return (rows);
	}
	else
	{
		cout << "Open error" << endl;
		in.close();
		return (-1);
	}
}

float	**matrix_of_point(char *av)
{
	int		rows;
	float	**ar;

	rows = count_rows(av);
	ar = create_array(rows, 2);
	ifstream in(av);
    if (!in.is_open())
    {
        cout << "Error" << endl;
    }
    else
	{
        cout << "File is open" << endl;
        for (size_t i = 0; i != rows; ++i)
        {
            for (size_t j = 0; j != 2; ++j)
            {
                in >> ar[i][j];
            }
        }
    }
	return (ar);
}

t_line	init_line(float *point1, float *point2)
{
	t_line a;

	a.x = point1[1] - point2[1];
	a.y = point2[0] - point1[0];
	a.c = point1[0] * point2[1] - point2[0] * point1[1];
	return (a);
}

int		check_vertex(float **fig, float *points)
{
	size_t	j;
	int		res;

	res = 3;
	j = 0;
	while (j != 4)
	{
		if (points[0] == fig[j][0] && points[1] == fig[j][1])
		{
			res = 0;
			break;
		}
		j++;
	}
	return (res);
}

int		check_position(float **fig, float *points)
{
	t_line	a[4];
	int		res;
	size_t	j;

	for (size_t i = 0; i != 3; ++i)
		a[i] = init_line(fig[i], fig[i + 1]);
	a[3] = init_line(fig[3], fig[0]);
	res = check_vertex(fig, points);
	if (res == 0)
		return (res);
	else
	{
		if (((points[0] * a[0].x + points[1] * a[0].y + a[0].c <= 0) &&
				(points[0] * a[1].x + points[1] * a[1].y + a[1].c <= 0) &&
				(points[0] * a[2].x + points[1] * a[2].y + a[2].c <= 0) &&
				(points[0] * a[3].x + points[1] * a[3].y + a[3].c <= 0)) ||
				((points[0] * a[0].x + points[1] * a[0].y + a[0].c >= 0) &&
				(points[0] * a[1].x + points[1] * a[1].y + a[1].c >= 0) &&
				(points[0] * a[2].x + points[1] * a[2].y + a[2].c >= 0) &&
				(points[0] * a[3].x + points[1] * a[3].y + a[3].c >= 0)))

		{
			if (((points[0] * a[0].x + points[1] * a[0].y + a[0].c == 0) ||
				(points[0] * a[1].x + points[1] * a[1].y + a[1].c == 0) ||
				(points[0] * a[2].x + points[1] * a[2].y + a[2].c == 0) ||
				(points[0] * a[3].x + points[1] * a[3].y + a[3].c == 0)))
				res = 1;
			else
				res = 2;
		}
		return (res);
	}
}

int		main(int ac, char **av)
{
    float **fig;
	float **points;
	int		rows;

	fig = matrix_of_point(av[1]);
	points = matrix_of_point(av[2]);
	rows = count_rows(av[2]);
	for (size_t i = 0; i != rows; ++i)
	{
		cout << check_position(fig, points[i]) << endl;
	}
    return 0;
}
