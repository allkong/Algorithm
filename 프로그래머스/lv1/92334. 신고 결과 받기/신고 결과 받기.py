def solution(id_list, report, k):
    answer = [0] * len(id_list)
    cnt = {i: 0 for i in id_list}
    report = list(set(report))
    
    for r in report:
        user_id, report_id = r.split()
        cnt[report_id] += 1
    
    for r in report:
        user_id, report_id = r.split()
        if cnt[report_id] >= k:
            answer[id_list.index(user_id)] += 1

    return answer