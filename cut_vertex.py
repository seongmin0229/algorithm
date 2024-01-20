def find_cut_vertices_corrected(graph):
    """Corrected function to find cut vertices in an undirected graph using DFS"""
    time = 0
    n = len(graph)
    visited = [False] * n
    disc = [-1] * n
    low = [-1] * n
    parent = [-1] * n
    cut_vertices = set()

    def dfs(u):
        nonlocal time
        children = 0
        visited[u] = True
        disc[u] = low[u] = time
        time += 1

        for v in graph[u]:
            if not visited[v]:
                parent[v] = u
                children += 1
                dfs(v)
                low[u] = min(low[u], low[v])

                if parent[u] == -1 and children > 1:
                    cut_vertices.add(u)
                elif parent[u] != -1 and low[v] >= disc[u]:
                    cut_vertices.add(u)

            elif v != parent[u]:
                low[u] = min(low[u], disc[v])

    for i in range(n):
        if not visited[i]:
            dfs(i)

    return sorted(cut_vertices)


vertex_count, edge_count = map(int, input().split())
edges = []
for _ in range(edge_count):
    u, v = map(int, input().split())
    edges.append((u - 1, v - 1))
undirected_graph = [[] for _ in range(vertex_count)]
for u, v in edges:
    undirected_graph[u].append(v)
    undirected_graph[v].append(u)

corrected_cut_vertices = find_cut_vertices_corrected(undirected_graph)

print(" ".join(str(vertex + 1) for vertex in corrected_cut_vertices))
